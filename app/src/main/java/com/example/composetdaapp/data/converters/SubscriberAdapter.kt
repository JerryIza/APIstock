package com.example.composetdaapp.data.converters

import com.example.composetdaapp.data.entities.websocket.request.LevelOneFutures
import com.squareup.moshi.ToJson


class SubscriberAdapter {
    @ToJson
    fun toJson(author: LevelOneFutures): String {
        return author.toString()
    }
}
