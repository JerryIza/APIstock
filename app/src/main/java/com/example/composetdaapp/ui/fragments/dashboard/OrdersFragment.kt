package com.example.composetdaapp.ui.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.composetdaapp.databinding.OrdersFragmentBinding
import com.example.composetdaapp.ui.adapters.OrdersAdapter
import com.example.composetdaapp.ui.theme.ComposeTdaAppTheme
import com.example.composetdaapp.viewmodels.MarketViewModel
import com.example.composetdaapp.ui.compose.orders.OrderScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

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

    }


    init {
        lifecycleScope.launchWhenResumed {
            while (isActive && this@OrdersFragment.isAdded) {
                //we need to get watchlist first and use string builder
                viewModel.getOrders()

                delay(4000)
            }
        }

    }


}