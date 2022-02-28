package com.example.composetdaapp.ui.fragments.dashFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.composetdaapp.MainActivity
import com.example.composetdaapp.R
import com.example.composetdaapp.data.entities.account.Positions
import com.example.composetdaapp.data.entities.quotes.SymbolDetails
import com.example.composetdaapp.databinding.PositionsFragmentBinding
import com.example.composetdaapp.ui.adapters.PositionsAdapter
import com.example.composetdaapp.ui.viewmodels.MarketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PositionsFragment:Fragment() {

    private lateinit var mainActivity: MainActivity
    private lateinit var pAdapter: PositionsAdapter
    private lateinit var binding : PositionsFragmentBinding

    private val viewModel: MarketViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PositionsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainActivity = activity as MainActivity
        setUpObservers()
    }


    private fun setupRecyclerViews() {

        val positionList = arrayListOf<Pair<Positions, SymbolDetails>>()
        pAdapter = PositionsAdapter(positionList) {
            mainActivity.tickerSymbol = (positionList[it].second.symbol)
            findNavController().navigate(R.id.action_dashboardFragment_to_stockDetailsFragment)
        }
        binding.positionRv.layoutManager = LinearLayoutManager(requireContext())
        binding.positionRv.adapter = pAdapter
    }



    private fun setUpObservers(){
        setupRecyclerViews()

        viewModel.posMediatorLiveData.observe(viewLifecycleOwner, {


            if (it.toString().isNotEmpty()) {

                pAdapter.setItems(
                    it
                )
                pAdapter.notifyDataSetChanged()
            }
        })
    }

}