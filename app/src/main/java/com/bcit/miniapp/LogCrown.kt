package com.bcit.miniapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bcit.miniapp.state.CrownState
import com.bcit.miniapp.state.MonsterState

@Composable
fun LogCrown() {
    val crownState: CrownState = viewModel(viewModelStoreOwner = LocalActivity.current as ComponentActivity)
    val monsterState: MonsterState = viewModel(viewModelStoreOwner = LocalActivity.current as ComponentActivity)

    val monsters = listOf(
        "Ajarakan",
        "Arkveld",
        "Balahara",
        "Blagonga",
        "Chatacabra",
        "Congalala",
        "Doshaguma",
        "Gore Magala",
        "Gravios",
        "Guardian Arkveld",
        "Gaurdian Doshaguma",
        "Gaurdian Ebony Odogaron",
        "Guardian Fulgur Anjanath",
        "Guardian Ratholos",
        "Gypceros",
        "Hirabami",
        "Jin Dahaad",
        "Lala Barina",
        "Nerscylla",
        "Nu Udra",
        "Quematrice",
        "Rathalos",
        "Rathian",
        "Rey Dau",
        "Rompopolo",
        "Uth Duna",
        "Xu Wu",
        "Yian Kut-Ku",
        "Zoh Shia"
    )
    val crownTypes = listOf("Large Gold", "Small Gold", "Large Silver", "Small Silver")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEFF8))
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Log Crowns", fontSize = 30.sp)
        Text(
            "Keep track of monsters you found crowns for here.",
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        DropdownList(
            itemList = monsters,
            selectedIndex = monsterState.nameIndex,
            onItemClick = { index -> monsterState.onNameChange(index) },
            unselectedText = "Select a monster"
        )

        Spacer(modifier = Modifier.height(10.dp))

        DropdownList(
            itemList = crownTypes,
            selectedIndex = monsterState.crownIndex,
            onItemClick = { index -> monsterState.onCrownTypeChange(index) },
            unselectedText = "Select a crown to log"
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray),
            value = monsterState.notes,
            onValueChange = monsterState.onNoteChange,
            label = { Text("Notes") },
            textStyle = TextStyle(fontSize = 14.sp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Button(
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCAD7B0),
                    contentColor = Color.Black),
                onClick = {
                    crownState.delete()
                    monsterState.refreshTrigger = !monsterState.refreshTrigger
                }
            ) {
                Text("DELETE ALL ENTRIES")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCAD7B0),
                    contentColor = Color.Black),
                onClick = {
                    val selectedName = monsters.getOrNull(monsterState.nameIndex) ?: ""
                    val selectedCrown = crownTypes.getOrNull(monsterState.crownIndex) ?: ""

                    crownState.add(
                        com.bcit.miniapp.data.LargeMonster(
                            name = selectedName,
                            notes = monsterState.notes,
                            crownSmallSilver = selectedCrown == "Small Silver",
                            crownLargeSilver = selectedCrown == "Large Silver",
                            crownSmallGold = selectedCrown == "Small Gold",
                            crownLargeGold = selectedCrown == "Large Gold"
                        )
                    )
                    monsterState.reset()
                    monsterState.refreshTrigger = !monsterState.refreshTrigger
                }
            ) {
                Text("LOG CROWN")
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))
        Text("Past Logs", fontSize = 22.sp, textDecoration = TextDecoration.Underline)
        Spacer(modifier = Modifier.padding(10.dp))
        PastLogs(crownState, monsterState.refreshTrigger)

        }
    }


@Composable
fun PastLogs(crownState: CrownState, refreshKey: Boolean) {
    val crowns = remember(refreshKey) { crownState.getAllCrowns() }

    LazyColumn {
        item {
            crowns.reversed().forEach {
                var crown = ""
                when {
                    it.crownLargeGold == true -> crown = "large gold crown"
                    it.crownSmallGold == true -> crown = "small gold crown"
                    it.crownLargeSilver == true -> crown = "large silver crown"
                    it.crownSmallSilver == true -> crown = "small silver crown"
                }
                Text("You logged a $crown for ${it.name}!", fontSize = 18.sp)
                if (!it.notes.isNullOrBlank()) {
                    Text("Notes: ${it.notes}", fontSize = 15.sp)
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun DropdownList(
    itemList: List<String>,
    selectedIndex: Int,
    onItemClick: (Int) -> Unit,
    unselectedText: String
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.border(1.dp,Color.Gray)) {
        Text(
            text = itemList.getOrNull(selectedIndex) ?: unselectedText,
            fontSize = 18.sp,
            modifier = Modifier
                .clickable { expanded = true }
                .padding(12.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.heightIn(max = 500.dp).background(Color.White)
        ) {
            itemList.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onItemClick(index)
                        expanded = false
                    }
                )
            }
        }
    }
}

