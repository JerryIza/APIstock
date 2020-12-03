package com.example.apistock.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apistock.R
import com.example.apistock.data.entities.SymbolSearch
import com.example.apistock.databinding.SearchFragmentBinding
import com.example.apistock.ui.adapters.SearchResultsAdapter
import com.example.apistock.ui.viewmodels.MarketMoversViewModel

class SearchFragment: Fragment() {

    private lateinit var binding: SearchFragmentBinding

    private lateinit var adapter: SearchResultsAdapter

    private val viewModel: MarketMoversViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpObservers()

        binding.searchSymbolInput.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.getSearchResults(s.toString())
            }

        })
    }

    private fun setUpRecyclerView(){
        val searchResults = arrayListOf<SymbolSearch>()
        adapter = SearchResultsAdapter(searchResults){
            viewModel.start(searchResults[it].symbol)
            findNavController().navigate(R.id.action_searchFragment_to_stockDetailsFragment)
        }
        binding.searchRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRecycler.adapter = adapter
    }

    private fun setUpObservers(){
        viewModel.searchResultsLiveData.observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) adapter.setItems(ArrayList(it.values))
        })
    }

}