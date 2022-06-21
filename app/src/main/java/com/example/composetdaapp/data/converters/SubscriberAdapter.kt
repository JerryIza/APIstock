package com.example.composetdaapp.data.converters

import com.example.composetdaapp.data.entities.websocket.request.Request
import com.squareup.moshi.ToJson


class SubscriberAdapter {
    @ToJson
    fun toJson(author: Request): String {
        return author.toString()
    }
}
