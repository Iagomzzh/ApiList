// Archivo: app/src/main/java/com/example/apilist/ui/screens/FavoritesScreen.kt
package com.example.apilist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.apilist.data.database.CharacterEntity
import com.example.apilist.viewmodel.Screen1ViwModel

@Composable
fun FavoritesScreen(myViewModel: Screen1ViwModel) {
    // Observar la lista de favoritos
    val favorites: List<CharacterEntity> by myViewModel.favorites.observeAsState(emptyList())

    // Obtener favoritos al iniciar la pantalla
    LaunchedEffect(Unit) {
        myViewModel.fetchFavorites()
    }

    if (favorites.isEmpty()) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.secondary)
        }
    } else {
        LazyColumn(Modifier.fillMaxSize()) {
            items(favorites) { favorite ->
                Text(
                    text = "${favorite.firstName} ${favorite.name} - ${favorite.username}",
                    modifier = Modifier
                )
            }
        }
    }
}