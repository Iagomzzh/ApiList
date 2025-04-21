// Archivo: src/main/java/com/example/apilist/ui/screens/SearchBar.kt
package com.example.apilist.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchTopBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        colors = TextFieldDefaults.colors(

            cursorColor = Color.White,
            disabledContainerColor = Color.Black,
            focusedTextColor = Color.White,
            ),


        modifier = modifier

            .fillMaxWidth()
            .padding(8.dp),
        label = { Text("Buscar", color = Color.White) },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { onQueryChanged("") }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Limpiar búsqueda",
                        tint = Color(0xFFFA7E1E)
                    )
                }
            }
        },

    )
}