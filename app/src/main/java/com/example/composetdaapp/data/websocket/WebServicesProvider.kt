package com.example.composetdaapp.data.websocket

import com.example.composetdaapp.utils.MyPreference
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import okhttp3.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class WebServicesProvider @Inject constructor(private val myPreference: MyPreference) {
    private var _webSocket: WebSocket? = null


    private val socketOkHttpClient = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(39, TimeUnit.SECONDS)
        .hostnameVerifier { _, _ -> true }
        .build()

    //we don't have to instantiate again? and pass through repo
    @ExperimentalCoroutinesApi
    private var _webSocketListener: StockSocketListener? = null

    @ExperimentalCoroutinesApi
    fun startSocket(): Channel<SocketUpdate> =
        with(StockSocketListener(myPreference)) {
            startSocket(this)

            this@with.socketEventChannel
        }



    @ExperimentalCoroutinesApi
    fun startSocket(webSocketListener: StockSocketListener) {
        _webSocketListener = webSocketListener
        _webSocket = socketOkHttpClient.newWebSocket(
            Request.Builder().url("ws://streamer-ws.tdameritrade.com/ws").build(),
            webSocketListener
        )
        try{_webSocket}
        catch (ex: Exception) {}
        socketOkHttpClient.dispatcher.executorService.shutdown()
    }

    @ExperimentalCoroutinesApi
    fun sendSocketRequest(payLoad: String){
        _webSocket?.send(payLoad)
    }





    @ExperimentalCoroutinesApi
    fun stopSocket() {
        try {
            _webSocket?.close(NORMAL_CLOSURE_STATUS, null)
            _webSocket = null
            _webSocketListener?.socketEventChannel?.close()
            _webSocketListener = null
        } catch (ex: Exception) {
        }
    }

    companion object {
        const val NORMAL_CLOSURE_STATUS = 1000
    }

}