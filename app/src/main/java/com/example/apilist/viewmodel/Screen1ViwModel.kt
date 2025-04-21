// Archivo: app/src/main/java/com/example/apilist/viewmodel/Screen1ViwModel.kt
package com.example.apilist.viewmodel

import Repository
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apilist.data.network.Response.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Screen1ViwModel : ViewModel() {

    private val _loading = MutableLiveData(true)
    val loading = _loading


    // Se usa una lista de Result, pues es la parte de la respuesta que queremos acumular.
    private val _characters = MutableLiveData<List<Result>>(emptyList())
    val characters get() = _characters

    private val _indexDetails = MutableLiveData<Int>(0)
    val indexDetails = _indexDetails

    private val _buttonFollow = MutableLiveData(false)
    val buttonFollow =_buttonFollow



    fun changeStatButoonFollor(indice:Int){

    }

    fun setIndeDetials(numberIndex: Int) {
        _indexDetails.value = numberIndex
    }


    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = Repository().getAllCharacters()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        // Extraer la lista de resultados de la respuesta. En caso de nulo se usa una lista vacía.
                        val newResults = response.body()?.results ?: emptyList()
                        // Se concatena la nueva lista con la existente.
                        _characters.value = _characters.value.orEmpty() + newResults
                        // Ejemplo de log: se imprime el primer nombre del primer resultado.
                        _loading.value = false

                        if (_characters.value?.isNotEmpty() == true) {
                            Log.d("CHIVATO", "${_characters.value?.get(0)?.name?.first}")
                        }
                    } else {
                        Log.e("Error :", response.message())
                    }
                }
            } catch (e: Exception) {
                Log.e("Exception", e.message ?: "Error desconocido")
            }
        }
    }
}