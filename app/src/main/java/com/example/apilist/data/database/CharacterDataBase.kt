package com.example.apilist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = arrayOf(CharacterEntity::class), version = 1)
abstract class CharacterDataBase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
