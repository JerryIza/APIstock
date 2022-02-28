package com.example.composetdaapp.data.websocket

import com.example.composetdaapp.data.websocket.WebServicesProvider.Companion.NORMAL_CLOSURE_STATUS
import com.example.composetdaapp.utils.MyPreference
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import javax.inject.Inject


@ExperimentalCoroutinesApi
class StockSocketListener @Inject constructor(private val myPreference: MyPreference) : WebSocketListener() {
    val socketEventChannel: Channel<SocketUpdate> = Channel(10)


    override fun onOpen(webSocket: WebSocket, response: Response) {
        webSocket.send(myPreference.getSocketCredentials())

        println("OPENED WEB SOCKET")
    }



    override fun onMessage(webSocket: WebSocket, text: String) {
        GlobalScope.launch {
            socketEventChannel.send(SocketUpdate(text))
            println("onMessage: " + text)
        }
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        GlobalScope.launch {
            socketEventChannel.send(SocketUpdate(exception = SocketAbortedException()))

        }
        println("onClosing: ")

        webSocket.close(NORMAL_CLOSURE_STATUS, null)

        socketEventChannel.close()
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        GlobalScope.launch {
            socketEventChannel.send(SocketUpdate(exception = t))
        }
    }




}

class SocketAbortedException : Exception()

data class SocketUpdate(
    val text: String? = null,
    val byteString: ByteString? = null,
    val exception: Throwable? = null
)