package com.bcit.miniapp.data

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("appnews")
    val appNews: News
)

data class News(
    @SerializedName("newsitems")
    val news: List<NewsArticles>
)

data class NewsArticles(
    val gid: String,
    val title: String,
    val url: String,
    val date: String
)