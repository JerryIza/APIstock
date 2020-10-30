package com.example.apistock.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apistock.R
import com.example.apistock.databinding.MainActivityBinding
import com.example.apistock.databinding.MarketMoversFragmentBinding
import com.example.apistock.ui.fragments.MarketMoversFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState== null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MarketMoversFragment.newInstance())
                .commitNow()
        }
    }
}
