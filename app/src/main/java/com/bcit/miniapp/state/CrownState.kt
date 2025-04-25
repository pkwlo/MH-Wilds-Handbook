package com.bcit.miniapp.state

import androidx.lifecycle.ViewModel
import com.bcit.miniapp.data.LargeMonster
import com.bcit.miniapp.data.MonsterRepository

// business logic state holder
class CrownState(private val repository: MonsterRepository): ViewModel() {
    fun add(monster: LargeMonster){
        repository.insertCrown(monster)
    }

    fun getAllCrowns(): List<LargeMonster> {
        return repository.getAllCrowns()
    }

    fun delete(){
        repository.deleteAll()
    }
}