package com.bcit.miniapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LargeMonster(){
    val largeMonster = stringArrayResource(R.array.large_monsters)
    val largeMonsterList = listOf(
        Monster(largeMonster[0], R.drawable.large_ajarakan, listOf("Oilwell Basin", "Ruins of Wyveria"), listOf("water", "ice"), listOf("fire"), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[1], R.drawable.large_arkveld, listOf("Windward Plains", "Scarlet Forest", "Oilwell Basin", "Iceshard Cliffs", "Ruins of Wyveria"), listOf("dragon"), emptyList(), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[2], R.drawable.large_balahara, listOf("Windward Plains"), listOf("thunder"), listOf("water"), listOf("paralysis", "exhaust")),
        Monster(largeMonster[3], R.drawable.large_blangonga, listOf("Iceshard Cliffs"), listOf("fire", "thunder"), listOf("dragon", "ice"), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[4], R.drawable.large_chatacabra, listOf("Windward Plains"), listOf("ice", "thunder"), listOf("dragon"), listOf("poison", "paralysis", "stun")),
        Monster(largeMonster[5], R.drawable.large_congalala, listOf("Scarlet Forest", "Ruins of Wyveria"), listOf("fire"), emptyList(), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[6], R.drawable.large_doshaguma, listOf("Windward Plains", "Scarlet Forest", "Ruins of Wyveria"), listOf("fire"), emptyList(), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[7], R.drawable.large_gore_magala, listOf("Iceshard Cliffs"), listOf("fire"), listOf("water"), listOf("blast", "exhaust")),
        Monster(largeMonster[8], R.drawable.large_gravios, listOf("Oilwell Basin", "Ruins of Wyveria"), listOf("water"), listOf("fire"), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[9], R.drawable.large_guardian_arkveld, listOf("Ruins of Wyveria"), listOf("dragon"), emptyList(), listOf("poison", "sleep", "paralysis", "blast", "stun")),
        Monster(largeMonster[10], R.drawable.large_guardian_doshaguma, listOf("Ruins of Wyveria"), listOf("fire", "ice"), emptyList(), listOf("poison", "sleep", "paralysis", "blast", "stun")),
        Monster(largeMonster[11], R.drawable.large_guardian_ebony_odogaron, listOf("Ruins of Wyveria"), listOf("water"), emptyList(), listOf("poison", "sleep", "paralysis", "blast", "stun")),
        Monster(largeMonster[12], R.drawable.large_guardian_fulgur_anjanath, listOf("Ruins of Wyveria"), listOf("ice"), listOf("thunder", "dragon"), listOf("poison", "sleep", "paralysis", "blast", "stun")),
        Monster(largeMonster[13], R.drawable.large_guardian_rathalos, listOf("Ruins of Wyveria"), listOf("dragon"), listOf("fire"), listOf("poison", "sleep", "paralysis", "blast", "stun")),
        Monster(largeMonster[14], R.drawable.large_gypceros, listOf("Windward Plains", "Scarlet Forest", "Oilwell Basin", "Iceshard Cliffs", "Ruins of Wyveria"), listOf("fire"), listOf("thunder"), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[15], R.drawable.large_hirabami, listOf("Iceshard Cliffs", "Ruins of Wyveria"), listOf("fire"), listOf("ice"), listOf("poison", "sleep")),
        Monster(largeMonster[16], R.drawable.large_jin_dahaad, listOf("Iceshard Cliffs"), listOf("fire"), listOf("ice"), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[17], R.drawable.large_lala_barina, listOf("Scarlet Forest", "Ruins of Wyveria"), listOf("fire"), listOf("water", "dragon"), listOf("stun")),
        Monster(largeMonster[18], R.drawable.large_nerscylla, listOf("Oilwell Basin", "Iceshard Cliffs", "Ruins of Wyveria"), listOf("fire"), listOf("watter", "thunder", "dragon"), listOf("paralysis")),
        Monster(largeMonster[19], R.drawable.large_nu_udra, listOf("Oilwell Basin"), listOf("water"), listOf("fire"), listOf("poison", "sleep", "stun", "exhaust")),
        Monster(largeMonster[20], R.drawable.large_quematrice, listOf("Windward Plains", "Ruins of Wyveria"), listOf("water"), listOf("fire"), listOf("poison", "paralysis")),
        Monster(largeMonster[21], R.drawable.large_rathalos, listOf("Scarlet Forest", "Oilwell Basin", "Ruins of Wyveria"), listOf("dragon"), listOf("fire"), listOf("sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[22], R.drawable.large_rathian, listOf("Windward Plains", "Scarlet Forest", "Oilwell Basin"), listOf("dragon"), listOf("fire"), listOf("sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[23], R.drawable.large_rey_dau, listOf("Windward Plains"), listOf("ice"), listOf("thunder"), listOf("poison", "sleep", "blast", "exhaust")),
        Monster(largeMonster[24], R.drawable.large_rompopolo, listOf("Oilwell Basin"), listOf("water"), emptyList(), listOf("sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[25], R.drawable.large_uth_duna, listOf("Scarlet Forest"), listOf("thunder"), listOf("water"), listOf("poison", "sleep", "paralysis", "blast", "exhaust")),
        Monster(largeMonster[26], R.drawable.large_xu_wu, listOf("Ruins of Wyveria"), listOf("ice"), listOf("dragon"), listOf("poison")),
        Monster(largeMonster[27], R.drawable.large_yian_kut_ku, listOf("Scarlet Forest", "Iceshard Cliffs"), listOf("thunder", "ice"), listOf("dragon"), listOf("poison", "sleep", "paralysis", "blast", "stun", "exhaust")),
        Monster(largeMonster[28], R.drawable.large_zoh_shia, listOf("Ruins of Wyveria"), listOf("dragon"), emptyList(), listOf("poison", "sleep", "paralysis", "blast"))
    )


    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Text("Large Monsters", fontSize = 30.sp)
            Text("Click to see more detailed monster information",
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 10.dp))
        }
        item{
            largeMonsterList.forEach{
                LargeMonsterCard(it)
            }
        }
    }
}

@Composable
fun LargeMonsterCard(monster: Monster) {
    var isExpanded by remember { mutableStateOf(false) }
    val firstWeakness = monster.elementalWeaknesses?.firstOrNull()
    val cardColor = when (firstWeakness) {
        "fire" -> Color(0xFFFF7777)
        "ice" -> Color(0xFF9EFAFF)
        "water" -> Color(0xFF7794FF)
        "thunder" -> Color(0xFFFFEC7C)
        "dragon" -> Color(0xFF9278F8)
        else -> Color.White
    }
    val padding = if (isExpanded) 20.dp else 5.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp)
            .background(color = cardColor)
            .clickable {
                isExpanded = !isExpanded
            }
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(monster.imageResId),
                    contentDescription = null,
                    modifier = Modifier.padding(padding)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(monster.name.replaceFirstChar { it.uppercase() }, fontSize = 20.sp)
            }
            if (isExpanded) {
                Column(modifier = Modifier.padding(20.dp)) {
                    InfoRow("Elemental Weakness(es): ", monster.elementalWeaknesses)
                    InfoRow("Elemental Resistance(s): ", monster.elementalResistances)
                    InfoRow("Status Weakness(es): ", monster.statusWeaknesses)
                    InfoRow("Locations: ", monster.location)
                }
            }
        }
    }
}

@Composable
fun InfoRow(label: String, items: List<String>?) {
    Row {
        Text(label, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        if (!items.isNullOrEmpty()) {
            Text(items.joinToString(", ") { it.replaceFirstChar { c -> c.uppercase() } }, fontSize = 15.sp)
        } else {
            Text("None")
        }
    }
}
