// Kotlin
package com.example.apilist.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.apilist.data.network.Response.Result
import com.example.apilist.ui.components.InstagramProfile
import com.example.apilist.viewmodel.Screen1ViwModel

@Composable
fun ApiListScreen(myViewModel: Screen1ViwModel, navController: NavController) {
    val characters: List<Result> by myViewModel.characters.observeAsState(emptyList())
    myViewModel.getCharacters()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(characters) { index, character ->
            // Envolvemos el componente en un clickable (o bien agregamos un callback en InstagramProfile)
            InstagramProfile(
                profileImage = character.picture.medium,
                name = character.name.first,
                index,
                myViewModel
            )


        }
    }
}