package com.example.apilist.data.database

import android.app.Application
import androidx.room.Room

class CharacterApp : Application() {
    companion object {
        lateinit var database: CharacterDataBase
    }
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, CharacterDataBase::class.java, "CharacterDatabase").build()
    }
}