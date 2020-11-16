package com.example.apistock.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apistock.R
import com.example.apistock.databinding.MainActivityBinding
import com.example.apistock.databinding.MarketMoversFragmentBinding
import com.example.apistock.ui.fragments.MarketMoversFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
