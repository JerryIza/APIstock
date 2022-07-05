package com.example.composetdaapp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import android.content.Context.MODE_PRIVATE


//The values are only known on the compile-time though, as a result, no values may be assigned at runtime to const variables
const val SESSION_TOKEN: String = "SESSION_TOKEN"
const val REFRESH_TOKEN: String = "REFRESH_TOKEN"
const val SOCKET_CREDENTIALS: String = "SOCKET_CREDENTIALS"
const val ACCOUNT_NUMBER: String = "ACCOUNT_VALUE"
const val USER_ID: String = "USER_ID"
const val SPINNER_POS: String = "SPINNER_POS"
//TEST 2
@Singleton
class MyPreference @Inject constructor(@ApplicationContext context: Context) {

    private val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val encPrefs = EncryptedSharedPreferences.create(
        "MySharedPreferences",
        masterKey,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getSpinnerPos(): Int = prefs.getInt(SPINNER_POS, 0)

    fun setSpinnerPos(query: Int) = prefs.edit().putInt(SPINNER_POS, query).apply()

    fun getAccessToken(): String = encPrefs.getString(SESSION_TOKEN, "")!!

    fun setAccessToken(query: String) = encPrefs.edit().putString(SESSION_TOKEN, query).apply()

    fun getRefreshToken(): String = encPrefs.getString(REFRESH_TOKEN, "")!!

    fun setRefreshToken(query: String) = encPrefs.edit().putString(REFRESH_TOKEN, query).apply()

    fun getSocketCredentials(): String = encPrefs.getString(SOCKET_CREDENTIALS, "")!!

    fun setSocketCredentials(query: String) =
        encPrefs.edit().putString(SOCKET_CREDENTIALS, query).apply()

    fun getAccountNumber(): String = encPrefs.getString(ACCOUNT_NUMBER, "")!!

    fun setAccountNumber(query: String) = encPrefs.edit().putString(ACCOUNT_NUMBER, query).apply()

    fun getDevUserId(): String = encPrefs.getString(USER_ID, "")!!

    fun setDevUserId(query: String) = encPrefs.edit().putString(USER_ID, query).apply()

    fun clearStoredTag() = encPrefs.edit().clear().apply()

}