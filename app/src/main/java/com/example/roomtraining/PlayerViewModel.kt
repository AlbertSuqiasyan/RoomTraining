package com.example.roomtraining

import android.app.Application
import androidx.lifecycle.*
import com.example.roomtraining.Data.Player
import com.example.roomtraining.Data.PlayerDatabaseDao
import kotlinx.coroutines.*

class PlayerViewModel(val databaseDao: PlayerDatabaseDao, application: Application) : AndroidViewModel(application) {
    val name = "gago"
    private var _aPlayer = MutableLiveData<Player?>()
    var aPlayer = _aPlayer

    private var _players = MutableLiveData<List<Player>>()
    var players: LiveData<List<Player>> = _players

    init {
        initializeAPlayer()
        initializePlayers()
    }

    private fun initializePlayers(){
        viewModelScope.launch {
                _players= getPlayersFromDatabase()

        }
    }

    private suspend fun getPlayersFromDatabase(): MutableLiveData<List<Player>> {
        return withContext(Dispatchers.IO){
            var players = databaseDao.getAllPlayers()
            players
        }
    }

    private fun initializeAPlayer() {
        viewModelScope.launch {
            _aPlayer.value = getAPlayerFromDatabase()
        }
    }

    private suspend fun getAPlayerFromDatabase(): Player? {
        return withContext(Dispatchers.IO) {
            var player = databaseDao.getAplayer()
            player
        }
    }

    fun createAPlayer(iq: String, skill: String, nickName: String) {
        viewModelScope.launch {
            if (iq != null && skill != null && nickName != null) {
                val player = Player(iq = iq.toInt(), skill = skill, nickName = nickName)
                insert(player)
                // return added player ID.
            }
        }
    }
    private suspend fun insert(player: Player){
        withContext(Dispatchers.IO){
            databaseDao.insert(player)
        }
    }

}