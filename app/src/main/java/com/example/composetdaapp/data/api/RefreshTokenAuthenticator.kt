package com.example.composetdaapp.data.api

import com.example.composetdaapp.utils.MyPreference
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject


class RefreshTokenAuthenticator @Inject constructor(
    private val myPreference: MyPreference
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request {
        //simply remove the Authorization header, nothing complex
        return response.request.newBuilder().removeHeader("Authorization").build()
    }
}
