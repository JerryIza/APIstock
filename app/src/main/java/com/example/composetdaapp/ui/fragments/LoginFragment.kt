package com.example.composetdaapp.ui.fragments

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
import com.example.composetdaapp.ui.viewmodels.LoginViewModel
import com.example.composetdaapp.R
import com.example.composetdaapp.data.api.API_KEY
import com.example.composetdaapp.databinding.LoginFragmentBinding

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


         if (viewModel.checkRefreshToken().isNotEmpty()){
             viewModel.refreshTokenAccess()
         }

        setUpObservers()
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
            myWebView.loadUrl("https://auth.tdameritrade.com/auth?response_type=code&redirect_uri=http%3A%2F%2Flocalhost&client_id=$API_KEY%40AMER.OAUTHAP")

            myWebView.webViewClient = object : WebViewClient() {
                override fun onReceivedError(
                    view: WebView,
                    errorCode: Int,
                    description: String,
                    failingUrl: String
                ) {
                    view.loadUrl("about:blank")
                    if (errorCode == 401) {
                        println("Error Code 401")
                        // show alert to enter username and password
                        // then when those are entered in the alert,
                        //     set it through the setHttpAuthUsernamePassword(...) shown below
                        //     and then reload the site
                    } else {
                        val decodedUrlCode = UrlQuerySanitizer(failingUrl).getValue("code")
                        viewModel.postTokenAccess(decodedUrlCode)
                    }
                }
            }
        }
    }
    private fun setUpObservers(){
        //First Authentication
        viewModel.tokenLiveData.observe(viewLifecycleOwner,){
            if (!it.isNullOrEmpty())  viewModel.tempUserPrincipals()
        }
        //Web Socket principals needed for login (2nd authentication for socket)
        viewModel.userPrincipalsLiveData.observe(viewLifecycleOwner,){
            if (it.streamerInfo.token.isNotEmpty())  findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        }


    }

}