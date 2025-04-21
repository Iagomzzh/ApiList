// Kotlin
package com.example.apilist.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.apilist.data.network.Response.Result
import com.example.apilist.ui.components.InstagramProfile
import com.example.apilist.viewmodel.Screen1ViwModel

@Composable
fun ApiListScreen(myViewModel: Screen1ViwModel, navController: NavController) {
    val characters: List<Result> by myViewModel.characters.observeAsState(emptyList())
    myViewModel.getCharacters()
    val showLoading: Boolean by myViewModel.loading.observeAsState(true)

    if (showLoading) {
        myViewModel.getCharacters()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.secondary
            )
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(characters) { index, character ->
                // Envolvemos el componente en un clickable (o bien agregamos un callback en InstagramProfile)
                InstagramProfile(
                    profileImage = character.picture.medium,
                    name = character.name.first,
                    index,
                    myViewModel,
                    navController
                )


            }
        }
    }
}