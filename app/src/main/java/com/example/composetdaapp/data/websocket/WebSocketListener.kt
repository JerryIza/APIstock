package com.example.composetdaapp.data.websocket

import com.example.composetdaapp.data.entities.websocket.DataResponse
import com.example.composetdaapp.data.entities.websocket.SocketUpdate
import com.example.composetdaapp.data.websocket.WebServicesProvider.Companion.NORMAL_CLOSURE_STATUS
import com.example.composetdaapp.utils.MyPreference
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject


@ExperimentalCoroutinesApi
class StockSocketListener @Inject constructor(
    private val myPreference: MyPreference,
    private val moshi: Moshi
) :
    WebSocketListener() {
    val socketEventChannel: Channel<SocketUpdate> = Channel(10)

    val jsonAdapter: JsonAdapter<DataResponse> = moshi.adapter(DataResponse::class.java)


    override fun onOpen(webSocket: WebSocket, response: Response) {
        webSocket.send(myPreference.getSocketCredentials())
        Timber.i("WebSocket onOpen %s", myPreference.getSocketCredentials())
    }


    override fun onMessage(webSocket: WebSocket, text: String) {
        GlobalScope.launch {
            val dataResponse = jsonAdapter.fromJson(text)

            socketEventChannel.send(SocketUpdate(dataResponse = dataResponse))
            Timber.i("WebSocket onMessage: %s", text)

        }
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        GlobalScope.launch {
            socketEventChannel.send(SocketUpdate(exception = SocketAbortedException()))


        }
        Timber.i("WebSocket onClosing: ")

        webSocket.close(NORMAL_CLOSURE_STATUS, null)

        socketEventChannel.close()
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        GlobalScope.launch {
            socketEventChannel.send(SocketUpdate(exception = t))
            Timber.i("WebSocket onException: ")
        }
    }
}

class SocketAbortedException : Exception()

