package com.example.apistock.utils

import android.content.Context
import androidx.preference.PreferenceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

const val SESSION_TOKEN : String = "SESSION_TOKEN"
@Singleton
class MyPreference @Inject constructor(@ApplicationContext context : Context){
    val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun getStoredTag(): String {
        return prefs.getString(SESSION_TOKEN, "")!!
    }
    fun setStoredTag(query: String) {
        prefs.edit().putString(SESSION_TOKEN, query).apply()
    }

    fun clearStoredTag() {
        prefs.edit().clear().apply()
    }

}