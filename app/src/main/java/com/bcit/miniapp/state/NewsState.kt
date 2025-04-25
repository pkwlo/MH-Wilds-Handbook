package com.bcit.miniapp.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bcit.miniapp.data.NewsRepository
import com.bcit.miniapp.data.NewsResponse
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NewsState(private val newsRepository: NewsRepository): ViewModel() {
    var newsArticle by mutableStateOf<NewsResponse?>(null)

    suspend fun getNews(){
        newsArticle = newsRepository.getNews()
    }

    fun formatUnixDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val format = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return format.format(date)
    }
}