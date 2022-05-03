package com.example.composetdaapp.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

//The values are only known on the compile-time though, as a result, no values may be assigned at runtime to const variables
const val SESSION_TOKEN: String = "SESSION_TOKEN"
const val REFRESH_TOKEN: String = "REFRESH_TOKEN"
const val SOCKET_CREDENTIALS: String = "SOCKET_CREDENTIALS"
const val ACCOUNT_NUMBER: String = "ACCOUNT_VALUE"
const val USER_ID: String = "USER_ID"

@Singleton
class MyPreference @Inject constructor(@ApplicationContext context: Context) {

    private val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val prefs = EncryptedSharedPreferences.create(
        "MySharedPreferences",
        masterKey,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )


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

    fun getSocketCredentials(): String {
        return prefs.getString(SOCKET_CREDENTIALS, "")!!
    }

    fun setSocketCredentials(query: String) {
        prefs.edit().putString(SOCKET_CREDENTIALS, query).apply()
    }

    fun getAccountNumber(): String {
        return prefs.getString(ACCOUNT_NUMBER, "")!!
    }

    fun setAccountNumber(query: String) {
        prefs.edit().putString(ACCOUNT_NUMBER, query).apply()
    }

    fun getDevUserId(): String {
        return prefs.getString(USER_ID, "")!!
    }

    fun setDevUserId(query: String) {
        prefs.edit().putString(USER_ID, query).apply()
    }

    fun clearStoredTag() {
        prefs.edit().clear().apply()
    }


}