package com.bcit.miniapp

data class Monster(
    val name: String,
    val imageResId: Int,
    val location: List<String>,
    val elementalWeaknesses: List<String>? = null,
    val elementalResistances: List<String>? = null,
    val statusWeaknesses: List<String>? = null
)

