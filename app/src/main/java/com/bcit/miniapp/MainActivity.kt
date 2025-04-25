package com.bcit.miniapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bcit.miniapp.data.MHDatabase
import com.bcit.miniapp.data.MonsterRepository
import com.bcit.miniapp.data.NewsRepository
import com.bcit.miniapp.data.client
import com.bcit.miniapp.state.CrownState
import com.bcit.miniapp.state.MonsterState
import com.bcit.miniapp.state.NewsState

class MainActivity : ComponentActivity() {
    private val db by lazy {
        MHDatabase.getDatabase(applicationContext)
    }
    private val monsterRepository by lazy {
        MonsterRepository(db.monsterDao())
    }
    private val newsRepository by lazy {
        NewsRepository(client)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(modifier = Modifier.safeDrawingPadding()){
                viewModel {
                    NewsState(newsRepository)
                }
                viewModel {
                    MonsterState()
                }
                viewModel {
                    CrownState(monsterRepository)
                }
                MainContent()
            }
        }
    }
}

