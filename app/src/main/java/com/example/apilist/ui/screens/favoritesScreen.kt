// Archivo: app/src/main/java/com/example/apilist/ui/screens/FavoriteListScreen.kt
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
import com.example.apilist.data.database.CharacterEntity
import com.example.apilist.ui.components.InstagramProfile
import com.example.apilist.viewmodel.Screen1ViwModel

@Composable
fun FavoriteListScreen(myViewModel: Screen1ViwModel, navController: NavController) {
    val favorites: List<CharacterEntity> by myViewModel.favorites.observeAsState(emptyList())
    var searchQuery by remember { mutableStateOf("") }
    val showLoading = favorites.isEmpty()

    LaunchedEffect(Unit) {
        myViewModel.fetchFavorites()
    }

    if (showLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.secondary)
        }
    } else {
        val filteredFavorites = if (searchQuery.isEmpty()) {
            favorites
        } else {
            favorites.filter { it.firstName.contains(searchQuery, ignoreCase = true) }
        }
        Column {
            SearchTopBar(query = searchQuery, onQueryChanged = { searchQuery = it })
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(filteredFavorites) { index, favorite ->
                    InstagramProfile(
                        profileImage = favorite.urlImage,
                        name = favorite.firstName,
                         index,
                        viewModel = myViewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}