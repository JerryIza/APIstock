package com.example.composetdaapp.navigation

import com.example.composetdaapp.other.Constants.HOME
import com.example.composetdaapp.other.Constants.LOGIN

sealed class Screen(var route: String) {
    object Login : Screen (route = LOGIN)
    object Home : Screen (route = HOME)
}