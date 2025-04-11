package com.example.apilist.data.network.Response

import android.provider.ContactsContract.Contacts.Data
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/?results=50&inc=name,picture,nat,login")
    suspend fun getData(): Response<userResponse>

    companion object {
        val BASE_URL = "https://randomuser.me/"
        fun create(): ApiInterface {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).client(client).build()
            return retrofit.create(ApiInterface::class.java)
        }
    }


}
