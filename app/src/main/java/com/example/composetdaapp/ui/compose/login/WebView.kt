package com.example.composetdaapp.ui.compose.login
/*
import android.annotation.SuppressLint
import android.net.UrlQuerySanitizer
import android.webkit.*
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.compose.animation.*
import androidx.compose.foundation.focusable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.os.postDelayed
import androidx.hilt.navigation.compose.hiltViewModel

@ExperimentalAnimationApi
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebView(
    urlToRender: String,
    navigateTo: () -> Unit
) {
    val viewModel = hiltViewModel<LoginViewModel>()


    AndroidView(factory = {
        WebView(it).apply {
            val webSettings: WebSettings = settings
            webSettings.javaScriptEnabled = true
            webSettings.domStorageEnabled = true
            webSettings.javaScriptCanOpenWindowsAutomatically = true
            webSettings.databaseEnabled = true
            webSettings.allowFileAccess = true
            webSettings.allowContentAccess = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return false
                }


                override fun onReceivedError(
                    view: WebView,
                    errorCode: Int,
                    description: String,
                    failingUrl: String
                ) {
                    viewModel.clearTokenAccess()

                    view.loadUrl("about:blank");


                    if (errorCode == 401) {
                        println("Error Code 401")
                        // show alert to enter username and password
                        // then when those are entered in the alert,
                        //     set it through the setHttpAuthUsernamePassword(...) shown below
                        //     and then reload the site
                    } else {
                        val decodedUrlCode = UrlQuerySanitizer(failingUrl).getValue("code")
                         viewModel.postTokenAccess(decodedUrlCode)
                        //shared preferences needs enough time to be updated from viewmodel

                        handler.postDelayed(1000L){navigateTo()}
                    }


                }
            }
        }
    }, update = {
        it.loadUrl(urlToRender)
    }, modifier = Modifier.focusable()
    )

}*/