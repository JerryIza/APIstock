package com.example.apistock.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apistock.R
import com.example.apistock.data.entities.account.Positions
import com.example.apistock.data.entities.quotes.SymbolDetails
import com.example.apistock.databinding.DashboardFragmentBinding
import com.example.apistock.ui.adapters.PositionsAdapter
import com.example.apistock.ui.adapters.WatchlistAdapter
import com.example.apistock.ui.viewmodels.MarketViewModel
import com.example.apistock.utils.Resource
import com.github.mikephil.charting.data.*
import kotlinx.coroutines.*
import kotlinx.datetime.*
import okhttp3.*
import java.util.*
import kotlin.collections.ArrayList


class DashboardFragment : Fragment() {

    private lateinit var binding: DashboardFragmentBinding

    private lateinit var wlAdapter: WatchlistAdapter

    private lateinit var pAdapter: PositionsAdapter

    var symbols: String = ""

    private val viewModel: MarketViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashboardFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        viewModel.getAllWatchlist()

        binding.refreshBtn.setOnClickListener { viewModel.refreshTokenAccess() }

        binding.autoCompleteTextView.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_searchFragment)

            findNavController().addOnDestinationChangedListener {
                    controller, destination, arguments ->
                findNavController().currentDestination?.label = "tehehe"

            }
        }
    }


    //val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryNames)


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

    private fun setupRecyclerView() {
        val watchlist = arrayListOf<SymbolDetails>()
        wlAdapter = WatchlistAdapter(watchlist) {
            viewModel.start(watchlist[it].symbol)
            findNavController().navigate(R.id.action_dashboardFragment_to_stockDetailsFragment)
        }
        binding.watchlistRv.layoutManager = LinearLayoutManager(requireContext())
        binding.watchlistRv.adapter = wlAdapter
        val positionList = ArrayList<Pair<Positions, SymbolDetails>>()
        pAdapter = PositionsAdapter(positionList) {
            viewModel.start(positionList[it].second.symbol)
            findNavController().navigate(R.id.action_dashboardFragment_to_stockDetailsFragment)
        }
        binding.positionRv.layoutManager = LinearLayoutManager(requireContext())
        binding.positionRv.adapter = pAdapter
    }


    private fun setUpObservers() {
        setupRecyclerView()
        viewModel.watchlistLiveData.observe(viewLifecycleOwner, {
            val stringBuilder = StringBuilder()

            when (it.status) {
                Resource.Status.SUCCESS -> {

                    binding.loadingBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) {
                        viewModel.accountPosDetails()

                        setUpSpinner()


                        binding.watchlistSp.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }

                                override fun onItemSelected(
                                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                                ) {
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
                Resource.Status.ERROR -> {
                    println(it.message)
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

                Resource.Status.LOADING ->
                    binding.loadingBar.visibility = View.VISIBLE
            }
        })

        viewModel.watchlistQuotes.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.loadingBar.visibility = View.GONE

                    if (!it.data.isNullOrEmpty()) {
                        wlAdapter.setItems((it.data.values))
                    }

                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.loadingBar.visibility = View.VISIBLE
            }
        })

        viewModel.accountDetailsLiveData.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {

                    binding.loadingBar.visibility = View.GONE
                    println(!it.data!!.securitiesAccount.positions.isNullOrEmpty())

                    if (!it.data.securitiesAccount.positions.isNullOrEmpty()) {

                        //pAdapter.setItems(it.dat.01.securitiesAccount.positions as MutableList<Positions>)
                    }

                    binding.accountValue.text =
                        ("$%,.2f".format(it.data.securitiesAccount.currentBalances.liquidationValue))


                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.loadingBar.visibility = View.VISIBLE
            }
        })

        viewModel.posLiveData.observe(viewLifecycleOwner, {

            if (it.toString().isNotEmpty()) {
                pAdapter.setItems(
                    it
                )
                pAdapter.notifyDataSetChanged()
            }
        })
    }

    //Not advisable to hit server every 1-5 seconds, regardless market movers only update every 10 seconds.
    init {
        lifecycleScope.launchWhenCreated {
            while (isActive && this@DashboardFragment.isAdded) {
                viewModel.getAccountDetails()
                //we need to get watchlist first and use string builder
                if (symbols.isNotEmpty()) {
                    viewModel.getMultiSymbolDetails(symbols)
                }
                delay(10000)
            }
        }
    }

}








