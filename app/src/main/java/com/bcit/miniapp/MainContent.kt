package com.bcit.miniapp

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import android.net.Uri
import com.bcit.miniapp.data.MonsterRepository
import com.bcit.miniapp.data.NewsRepository
import com.bcit.miniapp.state.MonsterState
import com.bcit.miniapp.state.NewsState

@Composable
fun MainContent() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                Home(navController)
            }
            composable("largeMonster"){
                LargeMonster()
            }
            composable("smallMonster"){
                SmallMonster()
            }
            composable("logCrown"){
                LogCrown()
            }
            composable("webview/{url}") {
                val encodedUrl = it.arguments?.getString("url")
                val decodedUrl = Uri.decode(encodedUrl)
                if (decodedUrl != null) {
                    WebViewScreen(decodedUrl)
                }
            }
        }
    }
}

@Composable
fun WebViewScreen(url: String) {
    val context = LocalContext.current
    val webView = remember { WebView(context) }

    AndroidView(factory = {
        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(url)
        }
    })

    BackHandler(enabled = webView.canGoBack()) {
        webView.goBack()
    }
}
