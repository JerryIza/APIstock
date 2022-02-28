package com.example.composetdaapp.ui.fragments.dashFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.composetdaapp.data.entities.orders.get.GetOrderItem
import com.example.composetdaapp.databinding.OrdersFragmentBinding
import com.example.composetdaapp.ui.adapters.OrdersAdapter
import com.example.composetdaapp.ui.theme.ComposeTdaAppTheme
import com.example.composetdaapp.ui.viewmodels.MarketViewModel
import com.example.composetdaapp.utils.Resource
import com.example.composetdaapp.ui.views.home.OrderScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : Fragment() {

    private lateinit var binding: OrdersFragmentBinding

    private lateinit var oAdapter: OrdersAdapter

    private val viewModel: MarketViewModel by activityViewModels()

    @ExperimentalAnimationApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OrdersFragmentBinding.inflate(inflater, container, false)
        binding.composeOrderList.apply {          // Dispose of the Composition when the view's LifecycleOwner
         // is destroyed
         setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
         setContent {
             // In Compose world
             ComposeTdaAppTheme {
              OrderScreen()
           }
         }
     }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpObservers()
        viewModel.getOrders()

    }

    private fun setupRecyclerView(){
        val ordersList = arrayListOf<GetOrderItem>()
        oAdapter = OrdersAdapter(ordersList){

        }
        binding.ordersRv.layoutManager = LinearLayoutManager(requireContext())
        binding.ordersRv.adapter = oAdapter

    }


    private fun setUpObservers() {
        setupRecyclerView()

        viewModel.ordersLiveData.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()){
                        oAdapter.setItems(
                            it.data
                        )


                    }

                }

                Resource.Status.ERROR -> {
                    println(it.message)
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

                Resource.Status.LOADING ->{


                }


            }

        })

    }

}