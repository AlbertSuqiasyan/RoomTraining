package com.example.roomtraining.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlayerDatabaseDao{
    @Insert
    fun insert(player: Player)

    @Update
    fun update(player: Player)

    @Query("SELECT * from player_table WHERE id = :key")
    fun get(key: Int): Player?

    @Query("DELETE FROM player_table")
    fun clear()

    @Query("SELECT * FROM player_table ORDER BY id DESC LIMIT 1")
    fun getAplayer(): Player?

    @Query("SELECT nick_name FROM player_table ORDER BY id DESC LIMIT 1")
    fun getPlayerNickName(): String

    @Query("SELECT * FROM player_table ORDER BY id")
    fun getAllPlayers(): MutableLiveData<List<Player>>
}