package com.bcit.miniapp

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bcit.miniapp.data.COUNT
import com.bcit.miniapp.data.NewsRepository
import com.bcit.miniapp.state.NewsState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun Home(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEFF8)),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(end = 15.dp, bottom = 20.dp)
                    .height(400.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = null
            )
            Column {
                Text("Monster Hunter Wilds", fontSize = 30.sp)
                Text("Interactive Hunter Handbook", fontSize = 20.sp)
            }
            Column {
                News(navController)
            }
        }
    }
}

@Composable
fun News(navController: NavController){
    val newsState: NewsState = viewModel(viewModelStoreOwner = LocalActivity.current as ComponentActivity)
    LaunchedEffect(newsState) {
        newsState.getNews()
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "News & Updates",
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline
        )
    }
    LazyColumn(
        modifier = Modifier.padding(start=25.dp, end = 25.dp, top = 10.dp)
    ) {
        items(COUNT.toInt()){
            val item = newsState.newsArticle?.appNews?.news?.get(it)
            Row {
                item?.date?.let { date ->
                    Text(
                        text = newsState.formatUnixDate(date.toLong()),
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    item?.title ?: "",
                    modifier = Modifier.clickable {
                        val encodedUrl = Uri.encode(item?.url ?: "")
                        navController.navigate("webview/$encodedUrl")
                    }
                )
            }
        }
    }
}