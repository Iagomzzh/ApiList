package com.example.apilist.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CharacterEntity")
    suspend fun getAllCharacters(): MutableList<CharacterEntity>
    @Query("SELECT * FROM CharacterEntity WHERE idPosition = :characterId")
    suspend fun getCharacterById(characterId: Int): CharacterEntity
    @Insert
    suspend fun addCharacter(character: CharacterEntity)
    @Delete
    suspend fun deleteCharacter(character: CharacterEntity)


    @Query("DELETE FROM CharacterEntity")
    suspend fun deleteAllCharacters(): Int
}
