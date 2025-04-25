package com.bcit.miniapp.data

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Entity(tableName = "large_monster")
data class LargeMonster(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String?,
    @ColumnInfo(name="crown_small_silver") val crownSmallSilver: Boolean?,
    @ColumnInfo(name="crown_large_silver") val crownLargeSilver: Boolean?,
    @ColumnInfo(name="crown_small_gold") val crownSmallGold: Boolean?,
    @ColumnInfo(name="crown_large_gold") val crownLargeGold: Boolean?,
    val notes: String?
)

@Dao
interface MonsterDao{
    @Query("SELECT * FROM large_monster")
    fun getAllCrowns(): List<LargeMonster>

    @Insert
    fun addCrown(monster: LargeMonster)

    @Query("DELETE FROM large_monster")
    fun deleteAll()

}

@Database(entities = [LargeMonster::class], version = 1)
abstract class MonsterDatabase : RoomDatabase(){
    abstract fun monsterDao() : MonsterDao
}

object MHDatabase{
    fun getDatabase(context: Context) : MonsterDatabase{
        return Room.databaseBuilder(
            context,
            MonsterDatabase::class.java,
            "my_db"
        ).allowMainThreadQueries().build()
    }
}