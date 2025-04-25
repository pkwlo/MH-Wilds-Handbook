package com.bcit.miniapp.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsRepository(private val httpClient: HttpClient) {
    suspend fun getNews(): NewsResponse{
        val response = httpClient.get(FILTERED_URL)
        val json = response.body<JsonObject>().toString()
        return Gson().fromJson(json, NewsResponse::class.java)
    }
}