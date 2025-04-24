// Archivo: app/src/main/java/com/example/apilist/viewmodel/Screen1ViwModel.kt
package com.example.apilist.viewmodel

import Repository
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apilist.data.database.CharacterApp
import com.example.apilist.data.database.CharacterEntity
import com.example.apilist.data.network.Response.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Screen1ViwModel : ViewModel() {

    private val _loading = MutableLiveData(true)
    val loading = _loading

    // Lista de resultados de la API
    private val _characters = MutableLiveData<List<Result>>(emptyList())
    val characters get() = _characters

    // LiveData para favoritos (entidades guardadas en la BD)
    private val _favorites = MutableLiveData<List<CharacterEntity>>(emptyList())
    val favorites get() = _favorites

    private val _indexDetails = MutableLiveData<Int>(0)
    val indexDetails = _indexDetails

    private val _buttonFollow = MutableLiveData(false)
    val buttonFollow = _buttonFollow

    private val repository = Repository()

    fun changeStatButoonFollor(indice: Int) {
        _buttonFollow.value = !_buttonFollow.value!!
    }

    fun changeStatButoonFollorFalse() {
        _buttonFollow.value = false
    }

    fun setIndeDetials(numberIndex: Int) {
        _indexDetails.value = numberIndex
    }

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getAllCharacters()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val newResults = response.body()?.results ?: emptyList()
                        _characters.value = _characters.value.orEmpty() + newResults
                        _loading.value = false
                        Log.d("CHIVATO", _characters.value?.get(0)?.name?.first ?: "")
                    } else {
                        Log.e("Error", response.message())
                    }
                }
            } catch (e: Exception) {
                Log.e("Exception", e.message ?: "Error desconocido")
            }
        }
    }

    // Función para guardar el personaje en la base de datos al pulsar "seguir"
    fun addFavorite(position: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val list = _characters.value ?: return@launch
            if (position !in list.indices) return@launch
            val result = list[position]
            val characterEntity = CharacterEntity(
                idPosition = position,
                username = result.login.username,
                name = result.name.title + " " + result.name.last,
                firstName = result.name.first,
                age = result.dob.age,
                nat = result.nat,
                urlImage = result.picture.medium
            )
            try {
                repository.saveAsFavorite(characterEntity)
                // Opcional: actualizar la lista de favoritos después de guardar
                fetchFavorites()
            } catch (e: Exception) {
                Log.e("addFavorite", e.message ?: "Error al guardar favorito")
            }
        }
    }

    // Recupera la lista de favoritos de la base de datos
    fun fetchFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val favList = repository.getFavorites()
                withContext(Dispatchers.Main) {
                    _favorites.value = favList
                }
            } catch (e: Exception) {
                Log.e("fetchFavorites", e.message ?: "Error al obtener favoritos")
            }
        }
    }

    fun deleteAllLocal() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.deleteAllLocal()
                fetchFavorites()
            } catch (e: Exception) {
                Log.e("deleteAllLocal", e.message ?: "Error eliminando elementos locales")
            }
        }
    }
}