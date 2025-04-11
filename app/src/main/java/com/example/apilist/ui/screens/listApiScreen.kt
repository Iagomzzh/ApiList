// Kotlin
package com.example.apilist.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.apilist.data.network.Response.Result
import com.example.apilist.ui.components.InstagramProfile
import com.example.apilist.viewmodel.Screen1ViwModel

@Composable
fun Prueba(myViewModel: Screen1ViwModel) {
// Kotlin
    val characters: List<Result> by myViewModel.characters.observeAsState(emptyList())
    myViewModel.getCharacters()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(characters) { character ->
            InstagramProfile(character.picture.medium, character.name.first)
        }
    }
}


