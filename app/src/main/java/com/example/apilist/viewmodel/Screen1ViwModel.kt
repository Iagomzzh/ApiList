package com.example.apilist.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apilist.data.Data
import com.example.apilist.data.database.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Screen1ViwModel {

    private val repository = Repository()
    private val _characters = MutableLiveData<Data>()
    val characters = _characters
    fun getCharacters(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllCharacters()
            withContext(Dispatchers.Main) {
                if(response.isSuccessful){
                    _characters.value = response.body()
                    Log.e("HEcho :", response.message())

                }
                else{
                    Log.e("Error :", response.message())
                }
            }
        }
    }

}