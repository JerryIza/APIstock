package com.example.apistock.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
//T also known as "generic type parameter" which allows you specify a placeholder in class that must be filled whenever function is used.

@Suppress("UNCHECKED_CAST")
class StockViewModelFactory : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StockViewModel() as T
    }
}