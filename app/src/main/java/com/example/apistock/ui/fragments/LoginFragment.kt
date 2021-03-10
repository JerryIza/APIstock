package com.example.apistock.ui.fragments

import android.net.UrlQuerySanitizer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.apistock.R
import com.example.apistock.databinding.LoginFragmentBinding
import com.example.apistock.ui.viewmodels.LoginViewModel

class LoginFragment  : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signInBtn = binding.signInBtn

        signInBtn.setOnClickListener {

            viewModel.clearTokenAccess()

            signInBtn.visibility = View.GONE

            val myWebView = binding.myWebView

            val webSettings: WebSettings = myWebView.settings

            webSettings.javaScriptEnabled = true
            webSettings.domStorageEnabled = true
            webSettings.javaScriptCanOpenWindowsAutomatically = true
            webSettings.databaseEnabled = true
            myWebView.webViewClient = WebViewClient()
            myWebView.loadUrl("https://auth.tdameritrade.com/auth?response_type=code&redirect_uri=http%3A%2F%2Flocalhost&client_id=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N%40AMER.OAUTHAP")

            myWebView.webViewClient = object : WebViewClient() {
                override fun onReceivedError(
                    view: WebView,
                    errorCode: Int,
                    description: String,
                    failingUrl: String
                ) {
                    if (errorCode == 401) {
                        println("Error Code 401")
                        // show alert to enter username and password
                        // then when those are entered in the alert,
                        //     set it through the setHttpAuthUsernamePassword(...) shown below
                        //     and then reload the site
                    } else {
                        val decodedToken = UrlQuerySanitizer(failingUrl).getValue("code")
                        println("Code: "+ decodedToken)
                        viewModel.postTokenAccess(decodedToken)

                        findNavController().navigate(R.id.action_loginFragment_to_marketMoversFragment)
                    }
                }
            }
        }
    }
}