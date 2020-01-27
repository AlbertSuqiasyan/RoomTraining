package com.example.roomtraining

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.roomtraining.Data.Player
import com.example.roomtraining.Data.PlayerDatabase
import com.example.roomtraining.Data.PlayerDatabaseDao
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException
import java.lang.Exception


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


    private lateinit var playerDao: PlayerDatabaseDao
    private lateinit var db: PlayerDatabase

    @Before
    fun createDb(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context,PlayerDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        playerDao = db.playerDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetPlayer(){
        val player = Player()
        playerDao.insert(player)
        val APlayer = playerDao.getAplayer()
        assertEquals(APlayer?.nickName,"")
    }
}
