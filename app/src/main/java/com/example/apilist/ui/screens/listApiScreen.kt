// Archivo: src/main/java/com/example/apilist/ui/screens/listApiScreen.kt
package com.example.apilist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.apilist.data.network.Response.Result
import com.example.apilist.ui.components.InstagramProfile
import com.example.apilist.viewmodel.Screen1ViwModel

@Composable
fun ApiListScreen(myViewModel: Screen1ViwModel, navController: NavController) {
    val characters: List<Result> by myViewModel.characters.observeAsState(emptyList())
    var searchQuery by remember { mutableStateOf("") }
    val showLoading: Boolean by myViewModel.loading.observeAsState(true)

    // Se ejecuta solo una vez al iniciar la pantalla
    LaunchedEffect(Unit) {
        myViewModel.changeStatButoonFollorFalse()
        myViewModel.getCharacters()
    }

    if (showLoading) {
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
        // Se filtra la lista de personajes según el query
        val filteredCharacters = if (searchQuery.isEmpty()) {
            characters
        } else {
            characters.filter { it.name.first.contains(searchQuery, ignoreCase = true) }.take(1)
        }
        Column {
            SearchTopBar(query = searchQuery, onQueryChanged = { searchQuery = it })
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(filteredCharacters) { index, character ->
                    InstagramProfile(
                        profileImage = character.picture.medium,
                        name = character.name.first,
                        index,
                        viewModel = myViewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}