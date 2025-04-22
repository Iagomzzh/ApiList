import com.example.apilist.data.database.CharacterApp
import com.example.apilist.data.database.CharacterEntity
import com.example.apilist.data.network.Response.ApiInterface

class Repository {
    val daoInterface = CharacterApp.database.characterDao()
    //Database functions
    suspend fun saveAsFavorite(character: CharacterEntity) = daoInterface.addCharacter(character)
    suspend fun deleteFavorite(character: CharacterEntity) = daoInterface.deleteCharacter(character)
    suspend fun isFavorite(characterId: Int) = daoInterface.getCharacterById(characterId)
    suspend fun getFavorites() = daoInterface.getAllCharacters()
}

