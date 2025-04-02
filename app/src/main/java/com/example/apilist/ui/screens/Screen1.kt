package com.example.apilist.ui.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.apilist.data.Data
import com.example.apilist.viewmodel.Screen1ViwModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//@Composable
//fun MyRecyclerView(myViewModel: Screen1ViwModel) {
//    val characters: Data  by myViewModel.characters.observeAsState(Data(0, emptyList(), true))
//    myViewModel.getCharacters()
//    LazyColumn(Modifier.fillMaxSize()) {
//        items(characters) {
//            CharacterItem(character = it)
//        }
//    }
//}
//
//@Composable
//fun CharacterItem(character: Character) {
//    Card(
//        border = BorderStroke(2.dp, Color.LightGray), shape = RoundedCornerShape(8.dp),
//        modifier = Modifier.padding(8.dp)) {
//        Row(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
//            Text(
//                text = character.name,
//                style = MaterialTheme.typography.bodyLarge,
//                textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize()
//            )
//        }
//    }
//}


@Composable
fun Prueba(myViewModel: Screen1ViwModel) {
    val characters: Data  by myViewModel.characters.observeAsState(Data(0, emptyList(), true))
   myViewModel.getCharacters()
    Text("Hola")
    Log.d("CHIVATO 1", "${
        characters}")
}