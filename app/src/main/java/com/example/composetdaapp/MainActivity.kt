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
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //We are using multiple view models and need at least one symbol variable shared across fragments
    var tickerSymbol = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.v("Activity Lifecycle onCreate")

        val binding: MainActivityBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.v("Activity Lifecycle onDestroy")



    }

}






