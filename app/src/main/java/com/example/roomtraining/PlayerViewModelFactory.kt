package com.example.roomtraining

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomtraining.Data.PlayerDatabaseDao

class PlayerViewModelFactory(val databaseDao: PlayerDatabaseDao,val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayerViewModel::class.java)) {
            return PlayerViewModel(databaseDao,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}