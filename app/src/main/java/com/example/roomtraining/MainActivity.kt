package com.example.roomtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.roomtraining.Data.PlayerDatabase
import com.example.roomtraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private val viewModel by lazy {
//        ViewModelProviders.of(this).get(PlayerViewModel::class.java)
//    }
    private lateinit var viewModel: PlayerViewModel
    private lateinit var viewModelFactory: PlayerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val application = requireNotNull(this).application
        val databaseDao = PlayerDatabase.getInstance(application).playerDatabaseDao
        viewModelFactory = PlayerViewModelFactory(databaseDao,application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(PlayerViewModel::class.java)

        viewModel.aPlayer.observe(this, Observer {
            binding.playerStats.text = "id: ${it?.id.toString()},iq: ${it?.iq.toString()},skill: ${it?.skill.toString()},nick: ${it?.nickName.toString()}"
        })

    }
}
//