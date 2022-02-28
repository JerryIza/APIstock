package com.example.composetdaapp.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.composetdaapp.other.Constants.ARG_OBJECT
import com.example.composetdaapp.ui.fragments.dashFragments.OrdersFragment
import com.example.composetdaapp.ui.fragments.dashFragments.PositionsFragment
import com.example.composetdaapp.ui.fragments.dashFragments.WatchlistFragment


class DashPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    //find a backspace fix

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        var fragment = Fragment()

        when (position) {
            0 -> fragment = WatchlistFragment()
            1 -> fragment = PositionsFragment()
            2 -> fragment = OrdersFragment()
        }


        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            when (position){
                0 -> putString(ARG_OBJECT, "Watchlist")
                1 -> putString(ARG_OBJECT, "Watchlist")
                2 -> putString(ARG_OBJECT, "Watchlist")
            }
        }




        return fragment
    }
}


