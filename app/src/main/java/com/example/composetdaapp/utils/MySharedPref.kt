package com.example.composetdaapp.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

const val SESSION_TOKEN : String = "SESSION_TOKEN"
const val REFRESH_TOKEN : String = "REFRESH_TOKEN"
const val SOCKET_CREDENTIALS : String = "SOCKET_CREDENTIALS"
@Singleton
class MyPreference @Inject constructor(@ApplicationContext context : Context){
    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getAccessToken(): String {
        return prefs.getString(SESSION_TOKEN, "")!!
    }
    fun setAccessToken(query: String) {
        prefs.edit().putString(SESSION_TOKEN, query).apply()
    }

    fun getRefreshToken(): String {
        return prefs.getString(REFRESH_TOKEN, "")!!
    }
    fun setRefreshToken(query: String) {
        prefs.edit().putString(REFRESH_TOKEN, query).apply()
    }

    fun clearStoredTag() {
        prefs.edit().clear().apply()
    }

    fun getSocketCredentials(): String {
        return prefs.getString(SOCKET_CREDENTIALS, "")!!
    }

    fun setSocketCredentials(query: String) {
        prefs.edit().putString(SOCKET_CREDENTIALS, query).apply()
    }

}