package com.example.composetdaapp.utils

import com.example.apistock.data.api.SocketRepository
import com.example.composetdaapp.data.websocket.SocketUpdate
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class SocketInteractor @Inject constructor(private val repository: SocketRepository) {

    @ExperimentalCoroutinesApi
    fun stopSocket() {
        repository.closeSocket()
    }

    @ExperimentalCoroutinesApi
    fun startSocket(): Channel<SocketUpdate> = repository.startSocket()


    @ExperimentalCoroutinesApi
    fun sendSocketRequest(payload: String) = repository.sendSocketRequest(payload)

}
