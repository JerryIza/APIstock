package com.example.apistock.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apistock.R
import com.example.apistock.api.SymbolDetails
import kotlinx.android.synthetic.main.main_fragment.*


private lateinit var Stock: String

class MainFragment : Fragment() {

    private lateinit var viewModel: StockViewModel

    val viewModelFactory = StockViewModelFactory()

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.main_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(StockViewModel::class.java)

        //call back receiving live data
        viewModel.stockLiveData.observe(viewLifecycleOwner, Observer {
            description.text = viewModel.stockLiveData.value.toString()
        })

        //edit text input, then use getStockDetails post value.
        btn.setOnClickListener {
            val inputStock = editSymbol.text.toString()
            Stock = inputStock
            viewModel.getStockDetails()
            }
        }


    }


val inputSymbol: String
    get() = Stock
