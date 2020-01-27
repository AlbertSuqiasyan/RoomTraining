package com.example.roomtraining.Koin

//import android.app.Application
//import androidx.room.Room
//import com.example.roomtraining.Data.PlayerDatabase
//import com.example.roomtraining.PlayerApp
//import com.example.roomtraining.PlayerViewModel
//import com.example.roomtraining.PlayerViewModelFactory
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//
//val appModule = module {
//    //application
//    single { Application() }
//    //databaseDao
//
//    single {
//        Room.databaseBuilder(PlayerApp(), PlayerDatabase::class.java, "players_database").build()
//    }
//    single {
//        get<PlayerDatabase>().playerDatabaseDao
//    }
//    //viewModelFactory
//    single { PlayerViewModelFactory(get(),get()) }
//}
//val viewModelModule = module {
//    //viewModel
//    viewModel { PlayerViewModel(get(),get()) }
//
//}