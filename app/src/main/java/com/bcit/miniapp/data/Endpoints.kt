package com.bcit.miniapp.data

// API ENDPOINTS
const val BASE_URL = "https://api.steampowered.com"
const val GET_NEWS = "${BASE_URL}/ISteamNews/GetNewsForApp/v2"
const val APP_ID = "2246340"
const val FEED = "steam_community_announcements"
const val COUNT = "5"
const val FILTERED_URL = "${GET_NEWS}/?appid=${APP_ID}&feeds=${FEED}&count=${COUNT}"
