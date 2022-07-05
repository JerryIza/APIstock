package com.example.composetdaapp.data.websocket

import com.example.composetdaapp.data.entities.websocket.SocketUpdate
import com.example.composetdaapp.data.websocket.SocketRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class SocketInteractor @Inject constructor(private val repository: SocketRepository) {
    //TODO move to viewmodel?
    @ExperimentalCoroutinesApi
    fun stopSocket() {
        repository.closeSocket()
    }

    @ExperimentalCoroutinesApi
    fun startSocket(): Channel<SocketUpdate> = repository.startSocket()


    @ExperimentalCoroutinesApi
    fun sendSocketRequest(payload: String) = repository.sendSocketRequest(payload)

}
