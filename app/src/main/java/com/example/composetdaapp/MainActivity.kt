package com.example.composetdaapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.composetdaapp.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //We are using multiple view models an need at least one symbol variable shared across fragments
    var tickerSymbol = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

       // show toolbar when these fragments are selected

       /* navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.chartFragment, R.id.searchFragment, R.id.chartSettingsFragment ->
                    binding.myToolbar.visibility = View.VISIBLE
                else -> binding.myToolbar.visibility = View.GONE
            }
        }*/
    }
}






