import com.example.apilist.data.database.CharacterApp
import com.example.apilist.data.database.CharacterEntity
import com.example.apilist.data.network.Response.ApiInterface

class Repository {
     val apiInterface = ApiInterface.create()
    val daoInterface = CharacterApp.database.characterDao()

    //API functions
    //get id
    // suspend fun getCharacterId(characterId: Int) = apiInterface.getDataId(characterId)

    //get all
    suspend fun getAllCharacters() = apiInterface.getData()

    //Database functions
    suspend fun saveAsFavorite(character: CharacterEntity) = daoInterface.addCharacter(character)

    suspend fun deleteFavorite(character: CharacterEntity) = daoInterface.deleteCharacter(character)

    suspend fun isFavorite(characterId: Int) = daoInterface.getCharacterById(characterId)

    suspend fun getFavorites() = daoInterface.getAllCharacters()
}

