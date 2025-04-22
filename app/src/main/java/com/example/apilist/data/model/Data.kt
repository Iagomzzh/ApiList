// Archivo: app/src/main/java/com/example/apilist/data/model/Data.kt
package com.example.apilist.data.model

import com.example.apilist.data.network.Response.Result

class Data(private val innerList: List<Result>) : List<Result> by innerList