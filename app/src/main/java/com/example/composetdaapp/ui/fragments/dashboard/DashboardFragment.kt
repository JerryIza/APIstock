package com.example.composetdaapp.ui.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.material.ExperimentalMaterialApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.composetdaapp.MainActivity
import com.example.composetdaapp.data.entities.websocket.response.Content
import com.example.composetdaapp.ui.adapters.IndicesAdapter
import com.example.composetdaapp.viewmodels.MarketViewModel
import com.example.composetdaapp.utils.Resource
import com.example.composetdaapp.R
import com.example.composetdaapp.databinding.DashboardFragmentBinding
import com.example.composetdaapp.ui.adapters.DashPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class DashboardFragment : Fragment (
) {

    //fragment needs to be attached to activity first.
    private lateinit var mainActivity: MainActivity
    private lateinit var binding: DashboardFragmentBinding
    private lateinit var iAdapter: IndicesAdapter
    private lateinit var dashPagerAdapter: DashPagerAdapter
    private lateinit var viewPager: ViewPager2

    private val viewModel: MarketViewModel by activityViewModels()


    @ExperimentalMaterialApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashboardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = activity as MainActivity
        setUpObservers()
        viewModel.subscribeToSocketEvents()


        dashPagerAdapter = DashPagerAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = dashPagerAdapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Watchlist"
                1 -> tab.text = "Positions"
                2 -> tab.text = "Orders"
            }
        }.attach()



        binding.autoCompleteTextView.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_searchFragment)
            findNavController().addOnDestinationChangedListener { controller, destination, arguments ->
                findNavController().currentDestination?.label = "tehehe"

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.cancel()
    }


    private fun setupRecyclerViews() {

        val indicesList = arrayListOf<Pair<String, Content>>()
        iAdapter = IndicesAdapter(indicesList) {
            indicesList[it].let { it1 -> viewModel.start(it1.first) }
        }
        binding.indicesRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.indicesRv.adapter = iAdapter


    }


    private fun setUpObservers() {
        setupRecyclerViews()




        viewModel.accountDetailsLiveData.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {

                    binding.loadingBar.visibility = View.GONE

                    binding.availFundsTv.text =
                        ("Option BP: $" + it.data!!.securitiesAccount.currentBalances.buyingPowerNonMarginableTrade.toString())
                    binding.accountValue.text =
                        ("$%,.2f".format(it.data.securitiesAccount.currentBalances.liquidationValue))
                    binding.stockBpTv.text =
                        ("Stock BP: $" + it.data.securitiesAccount.currentBalances.buyingPower.toString())


                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.loadingBar.visibility = View.VISIBLE
            }
        })


        //Resource status, after parsing object
        viewModel.webSocketLiveData.observe(viewLifecycleOwner, {
            if (it.toString().isNotEmpty()) {
                iAdapter.setItems(it)
                iAdapter.notifyDataSetChanged()
            }
        })
    }
    //Not advisable to hit server every 1-5 seconds, regardless http request only update every 10 seconds.
}

















