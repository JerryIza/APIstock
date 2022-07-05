package com.example.composetdaapp.data.entities.websocket

import okio.ByteString

data class SocketUpdate(
    val dataResponse: DataResponse? = null,
    val byteString: ByteString? = null,
    val exception: Throwable? = null
)