package com.bcit.miniapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SmallMonster(){
    val smallMonster = stringArrayResource(R.array.small_monsters)
    val smallMonsterList = listOf(
        Monster(smallMonster[0], R.drawable.small_baunos, listOf("Windward Plains")),
        Monster(smallMonster[1], R.drawable.small_blango, listOf("Iceshard Cliffs")),
        Monster(smallMonster[2], R.drawable.small_bulaqchi, listOf("Windward Plains")),
        Monster(smallMonster[3], R.drawable.small_ceratonoth, listOf("Windward Plains")),
        Monster(smallMonster[4], R.drawable.small_comaqchi, listOf("Iceshard Cliffs")),
        Monster(smallMonster[5], R.drawable.small_conga, listOf("Scarlet Forest")),
        Monster(smallMonster[6], R.drawable.small_dalthydon, listOf("Windward Plains", "Scarlet Forest")),
        Monster(smallMonster[7], R.drawable.small_gajios, listOf("Windward Plains", "Scarlet Forest")),
        Monster(smallMonster[8], R.drawable.small_gelidron, listOf("Oilwell Basin")),
        Monster(smallMonster[9], R.drawable.small_guardian_seikret, listOf("Ruins of Wyveria")),
        Monster(smallMonster[10], R.drawable.small_harpios, listOf("Scarlet Forest", "Oilwell Basin")),
        Monster(smallMonster[11], R.drawable.small_kranodath, listOf("Oilwell Basin")),
        Monster(smallMonster[12], R.drawable.small_nerscylla_hatchling, listOf("Iceshard Cliffs")),
        Monster(smallMonster[13], R.drawable.small_piragill, listOf("Scarlet Forest")),
        Monster(smallMonster[14], R.drawable.small_porkeplume, listOf("Iceshard Cliffs", "Ruins of Wyveria")),
        Monster(smallMonster[15], R.drawable.small_rafma, listOf("Iceshard Cliffs", "Ruins of Wyveria")),
        Monster(smallMonster[16], R.drawable.small_talioth, listOf("Windward Plains")),
        Monster(smallMonster[17], R.drawable.small_vespoid, listOf("Scarlet Forest", "Oilwell Basin", "Iceshard Cliffs", "Ruins of Wyveria"))
    )


    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Text("Small Monsters", fontSize = 30.sp)
            Text("Click to see more detailed monster information", fontSize = 15.sp, modifier = Modifier.padding(bottom = 10.dp))
        }
        item{
            smallMonsterList.forEach{
                SmallMonsterCard(it)
            }
        }
    }
}

@Composable
fun SmallMonsterCard(monster: Monster){
    var isExpanded by remember { mutableStateOf(false) }
    val padding = if (isExpanded) 20.dp else 5.dp
    Row(
        modifier= Modifier
            .fillMaxSize()
            .padding(bottom = (2.dp))
            .background(Color(0xFFEDEFF8))
            .clickable {
                isExpanded = !isExpanded
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Row(modifier = Modifier.padding(padding),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(monster.imageResId),
                    contentDescription = null,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Column {
                    Text(monster.name.replaceFirstChar { it.uppercase() }, fontSize = 20.sp)
                    Row {
                        Text(monster.location[0])
                    }
                }
            }
            if (isExpanded) {
                Column(modifier = Modifier.padding(20.dp)) {
                    InfoRow("All Location(s): ", monster.location)
                }
            }
        }

    }
}
