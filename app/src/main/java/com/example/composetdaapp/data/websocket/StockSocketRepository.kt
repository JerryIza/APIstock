package com.example.composetdaapp.data.websocket

import com.example.composetdaapp.data.entities.websocket.SocketUpdate
import com.example.composetdaapp.data.websocket.WebServicesProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class SocketRepository @Inject constructor(private val webServicesProvider: WebServicesProvider) {

    @ExperimentalCoroutinesApi
    fun startSocket(): Channel<SocketUpdate> =
        webServicesProvider.startSocket()

    @ExperimentalCoroutinesApi
    fun closeSocket() {
        webServicesProvider.stopSocket()
    }

    @ExperimentalCoroutinesApi
    fun sendSocketRequest(payLoad : String) {
        webServicesProvider.sendSocketRequest(payLoad = payLoad)
    }
}