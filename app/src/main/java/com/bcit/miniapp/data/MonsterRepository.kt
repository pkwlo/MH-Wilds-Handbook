package com.bcit.miniapp.data

class MonsterRepository(private val monsterDao: MonsterDao) {
    fun insertCrown(monster: LargeMonster){
        monsterDao.addCrown(monster)
    }
    fun getAllCrowns(): List<LargeMonster>{
        return monsterDao.getAllCrowns()
    }
    fun deleteAll(){
        monsterDao.deleteAll()
    }
}