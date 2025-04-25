package com.bcit.miniapp.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MonsterState: ViewModel() {
    var refreshTrigger by mutableStateOf(false)

    var nameIndex by mutableIntStateOf(-1)
    val onNameChange: (Int) -> Unit = { nameIndex = it }

    var crownIndex by mutableIntStateOf(-1)
    val onCrownTypeChange: (Int) -> Unit = { crownIndex = it }

    var notes by mutableStateOf("")
    val onNoteChange: (String) -> Unit = { notes = it }

    fun reset() {
        nameIndex = -1
        crownIndex = -1
        notes = ""
    }
}
