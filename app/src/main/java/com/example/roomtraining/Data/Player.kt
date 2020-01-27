package com.example.roomtraining.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "player_table")
    data class Player (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "iq")
    val iq: Int = 0,
    @ColumnInfo(name = "skill")
    val skill: String = "",
    @ColumnInfo(name = "nick_name")
    val nickName: String = ""
)