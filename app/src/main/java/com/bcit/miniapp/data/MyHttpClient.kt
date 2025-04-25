package com.bcit.miniapp.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.gson.gson

//const val API_KEY = "asdfasgawedfgdfg"

// etnry point to all our http requests
val client = HttpClient {
    install(ContentNegotiation){
        gson()
    }

//    defaultRequest {
//        header(HttpHeaders.Authorization, "Bearer $API_KEY")
//    }
}
