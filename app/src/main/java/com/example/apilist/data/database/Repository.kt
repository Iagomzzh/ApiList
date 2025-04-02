// Archivo: app/src/main/java/com/example/apilist/data/database/Repository.kt
package com.example.apilist.data.database

import com.example.apilist.data.Data
import retrofit2.Response

class Repository {
    private val apiInterface = ApiInterface.create()

    // Usamos searchProducts para enviar los parámetros de forma separada
    suspend fun getAllCharacters(): Response<Data> =
        apiInterface.searchProducts(query = "android", page = 1, geo = "us")
}