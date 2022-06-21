package com.example.composetdaapp.ui.fragments.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.composetdaapp.MainActivity
import com.example.composetdaapp.R
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.data.entities.watchlist.patch.PatchWatchlist
import com.example.composetdaapp.data.entities.watchlist.patch.WatchlistItems
import com.example.composetdaapp.databinding.WatchlistFragmentBinding
import com.example.composetdaapp.ui.adapters.WatchlistAdapter
import com.example.composetdaapp.viewmodels.MarketViewModel
import com.example.composetdaapp.utils.ARG_OBJECT
import com.example.composetdaapp.utils.MyPreference
import com.example.composetdaapp.utils.Resource
import com.example.composetdaapp.utils.Resource.Status.*
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import okhttp3.internal.notify
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class WatchlistFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
    private lateinit var binding: WatchlistFragmentBinding
    private lateinit var wlAdapter: WatchlistAdapter
    private lateinit var deletedSymbol: String
    private var spinPos: Int = 0
    private val viewModel: MarketViewModel by activityViewModels()

    val watchlist = arrayListOf<SymbolDetails>()
    var symbols: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WatchlistFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            mainActivity = activity as MainActivity
            spinPos = viewModel.getSpinnerPosition()
            setUpObservers()
            viewModel.getAllWatchlist()

        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.setSpinnerPosition(spinPos)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.cancel()
    }


    private fun setupRecyclerViews() {
        wlAdapter = WatchlistAdapter(watchlist) {
            mainActivity.tickerSymbol = watchlist[it].symbol
            findNavController().navigate(R.id.action_dashboardFragment_to_stockDetailsFragment)
        }
        binding.watchlistRv.layoutManager = LinearLayoutManager(requireContext())
        binding.watchlistRv.adapter = wlAdapter
        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.watchlistRv)
    }

    private var simpleCallback = object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP.or(ItemTouchHelper.DOWN),
        ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)
    ) {
        var watchListOnSwipe = mutableListOf<String?>()
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val startPosition = viewHolder.adapterPosition
            val endPositions = target.adapterPosition

            Collections.swap(watchListOnSwipe, startPosition, endPositions)
            recyclerView.adapter?.notifyItemMoved(startPosition, endPositions)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            when (direction) {
                ItemTouchHelper.LEFT -> {
                    deletedSymbol = watchListOnSwipe[position]!!
                    watchListOnSwipe.removeAt(position)
                    wlAdapter.notifyItemRemoved(position)


                    viewModel.patchWatchlist(
                        symbolUpdate = PatchWatchlist(
                            name = "updated",
                            watchlistId = "1923285313",
                            listOf(
                                WatchlistItems(
                                    instrument = null,
                                    sequenceId = position + 1
                                )
                            )
                        ),
                        watchlistId = "1923285313"
                    )
                }
            }
        }
    }

    private fun setUpSpinner() {
        val spinner: Spinner = binding.watchlistSp
        val spAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            viewModel.watchlistNames
        )
        // Specify the layout to use when the list of choices appears
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = spAdapter
        spAdapter.notifyDataSetChanged()
    }


    private fun setUpObservers() {
        setupRecyclerViews()
        viewModel.watchlistLiveData.observe(viewLifecycleOwner, {
            val stringBuilder = StringBuilder()
            when (it.status) {
                SUCCESS -> {
                    binding.loadingBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) {
                        //piggy backing off watchlist update
                        viewModel.accountPosDetails()
                        setUpSpinner()
                        binding.watchlistSp.setSelection(spinPos)
                        binding.watchlistSp.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }

                                override fun onItemSelected(
                                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                                ) {
                                    spinPos = position

                                    for (i in it.data[position].watchlistItems.indices) {
                                        stringBuilder.append(it.data[position].watchlistItems[i].instrument.symbol + ",")
                                    }
                                    //startQuotes(stringBuilder.toString())
                                    viewModel.getMultiSymbolDetails(stringBuilder.toString())
                                    symbols = stringBuilder.toString()
                                    stringBuilder.clear()
                                }
                            }
                    }
                }
                ERROR -> {
                    println(it.message)
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

                LOADING ->
                    binding.loadingBar.visibility = View.VISIBLE
            }
        })

        viewModel.patchLiveData.observe(viewLifecycleOwner, {
            when (it.status) {

                SUCCESS -> {

                    viewModel.getAllWatchlist()
                }
                ERROR -> TODO()
                LOADING -> TODO()
            }
        })

        viewModel.watchlistQuotes.observe(viewLifecycleOwner, { it ->
            when (it.status) {
                SUCCESS -> {
                    binding.loadingBar.visibility = View.GONE

                    if (!it.data.isNullOrEmpty()) {
                        it.data.keys.toCollection(simpleCallback.watchListOnSwipe)
                        val mutableList = it.data.values
                        mutableList.removeIf { it.symbol == "" }
                        wlAdapter.setItems((mutableList))
                    }

                }
                ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                LOADING ->
                    binding.loadingBar.visibility = View.VISIBLE
            }
        })
    }

    init {
        lifecycleScope.launchWhenResumed {
            while (isActive && this@WatchlistFragment.isAdded) {
                //we need to get watchlist first and use string builder
                if (symbols.isNotEmpty()) {
                    viewModel.getMultiSymbolDetails(symbols)
                    //viewModel.accountPosDetails()
                }
                delay(5000)
            }
        }

    }
}



