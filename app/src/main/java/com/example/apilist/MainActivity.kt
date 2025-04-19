// Kotlin
package com.example.apilist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.apilist.ui.navigation.Destinations
import com.example.apilist.ui.navigation.NavigationItem
import com.example.apilist.ui.navigation.NavigationWrapper
import com.example.apilist.ui.screens.ApiListScreen
import com.example.apilist.ui.theme.APIListTheme
import com.example.apilist.viewmodel.Screen1ViwModel

class MainActivity : ComponentActivity() {

    private val myViewModel: Screen1ViwModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        myViewModel.getCharacters()
        setContent {
            APIListTheme {
                MyApp(myViewModel)
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(myViewModel: Screen1ViwModel) {
    var selectedItem: Int by remember { mutableIntStateOf(0) }
    val items = listOf(
        NavigationItem("Home", Icons.Default.Home, Destinations.Pantalla1, 0),
        NavigationItem("Favorites", Icons.Default.Favorite, Destinations.Pantalla2, 1),
        NavigationItem("Settings", Icons.Default.Settings, Destinations.Pantalla3, 2)
    )
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    
                    selected = item.index == selectedItem,
                    label = { Text(item.label) },
                    icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                    onClick = {
                        selectedItem = index
                        navController.navigate(item.route)
                    },
                    colors =  NavigationBarItemDefaults.colors(contentColorFor(Color.Black), unselectedIconColor = Color.Black,)
                )
            }

        }
    }) {
        NavigationWrapper(navController, myViewModel)


    }
}