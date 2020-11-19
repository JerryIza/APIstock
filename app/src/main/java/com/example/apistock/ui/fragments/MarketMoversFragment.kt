package com.example.apistock.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apistock.R
import com.example.apistock.data.entities.MarketMovers
import com.example.apistock.databinding.MarketMoversFragmentBinding
import com.example.apistock.ui.adapters.MarketMoversAdapter
import com.example.apistock.ui.viewmodels.MarketMoversViewModel
import com.example.apistock.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


private var Stock = "\$SPX.X"


@AndroidEntryPoint
class MarketMoversFragment : Fragment() {

    private lateinit var binding: MarketMoversFragmentBinding

    private val viewModel: MarketMoversViewModel by activityViewModels()

    private lateinit var adapter: MarketMoversAdapter




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MarketMoversFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectMarket()
        setupRecyclerView()
        setUpObservers()

    }



    private fun selectMarket() {
        binding.marketSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                when (position) {
                    0 -> binding.marketSpinner.setSelection(0)
                    1 -> binding.marketSpinner.setSelection(1)
                    2 -> binding.marketSpinner.setSelection(2)
                }
                Stock = parent?.getItemAtPosition(position).toString()
                viewModel.getMoversDetails()
            }
        }
    }

    private fun setupRecyclerView() {
        val marketMovers = arrayListOf<MarketMovers>()
        adapter = MarketMoversAdapter(marketMovers) {
            viewModel.start(marketMovers[it].symbol)

            findNavController().navigate(R.id.action_marketMoversFragment_to_stockDetailsFragment)
        }
        binding.moversRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.moversRecycler.adapter = adapter
    }

    //With MVVM we use LiveData from our ViewModel, which is "Observable" and will update our adapter on data change.
    private fun setUpObservers() {
        viewModel.moversLiveData.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.loadingBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.loadingBar.visibility = View.VISIBLE
            }
        })
    }

    //Not advisable to hit server every 1-5 seconds, since server can take a few seconds to respond. Therefore leading to too many queued request -> crash :).
    init {
        lifecycleScope.launchWhenCreated {

            while (isActive && this@MarketMoversFragment.isAdded) {

                viewModel.getMoversDetails()
                delay(10000)
            }
        }
    }

}


val inputSymbol: String
    get() = Stock


