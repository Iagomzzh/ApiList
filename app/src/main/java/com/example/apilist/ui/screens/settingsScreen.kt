// Archivo: app/src/main/java/com/example/apilist/ui/screens/settingsScreen.kt
package com.example.apilist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apilist.viewmodel.Screen1ViwModel

@Composable
fun SettingsSc(myViewModel: Screen1ViwModel) {
    var isDarkMode by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var selectedViewMode by remember { mutableStateOf("Filas") }
    val viewModes = listOf("Filas", "Columnas")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Switch para alternar entre modo claro y oscuro
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Modo Oscuro", fontSize = 18.sp)
            Switch(
                checked = isDarkMode,
                onCheckedChange = { isDarkMode = it },
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        // Dropdown menu para seleccionar vista de la lista (filas/columnas)
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Vista: $selectedViewMode", fontSize = 18.sp)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                viewModes.forEach { mode ->
                    DropdownMenuItem(
                        text = { Text(mode) },
                        onClick = {
                            selectedViewMode = mode
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        // Botón para eliminar todos los elementos locales
        Button(
            onClick = { myViewModel.deleteAllLocal() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Eliminar todos los elementos locales", fontSize = 18.sp)
        }
    }
}