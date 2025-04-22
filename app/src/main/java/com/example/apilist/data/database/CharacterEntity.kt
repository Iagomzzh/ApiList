package com.example.apilist.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CharacterEntity")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val username: String,
    val name: String,
    val firstName: String,
    val age: Int,
    val nat: String,
    val urlImage: String
)
