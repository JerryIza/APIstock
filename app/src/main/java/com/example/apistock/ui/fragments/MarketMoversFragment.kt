package com.example.apistock.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apistock.api.MarketMovers
import com.example.apistock.databinding.MarketMoversFragmentBinding
import com.example.apistock.ui.viewmodels.StockViewModel
import com.example.apistock.ui.adapters.MarketMoversAdapter
import com.example.apistock.utils.Resource
import timber.log.Timber

private var Stock = "\$SPX.X"

class MarketMoversFragment : Fragment() {

    private lateinit var binding: MarketMoversFragmentBinding

    private lateinit var viewModel: StockViewModel

    private lateinit var adapter: MarketMoversAdapter


    companion object {
        fun newInstance() = MarketMoversFragment()
    }

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
        viewModel = ViewModelProvider(this).get(StockViewModel::class.java)
        selectMarket()
        setupRecyclerView()
        setUpObservers()
        viewModel.autoRefreshResults()
    }

    override fun onDestroy() {
        super.onDestroy()
        //We need to cancel auto refresh job, otherwise application will continue to make request, leading to a memory leak.
        viewModel.cancelRequest()
        Timber.i("OnDestroy")
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
                viewModel.getStockDetails()
            }
        }
    }

    private fun setupRecyclerView() {
        val dummyInputs = arrayListOf<MarketMovers>()
        adapter = MarketMoversAdapter(dummyInputs)
        binding.moversRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.moversRecycler.adapter = adapter
        adapter.notifyDataSetChanged()
    }
    //With MVVM we use LiveData from our ViewModel, which is "Observable" and will update our adapter on data change.
    private fun setUpObservers() {
        viewModel.stockLiveData.observe(viewLifecycleOwner, Observer {
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
}

    val inputSymbol: String
        get() = Stock
