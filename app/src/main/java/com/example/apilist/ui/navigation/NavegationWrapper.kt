// Kotlin
package com.example.apilist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.apilist.ui.screens.ApiListScreen
import com.example.apilist.ui.screens.DetailsSc
import com.example.apilist.ui.screens.FavoriteListScreen
import com.example.apilist.ui.screens.SettingsSc
import com.example.apilist.viewmodel.Screen1ViwModel

@Composable
fun NavigationWrapper(navController: NavHostController, viwModel: Screen1ViwModel) {
    NavHost(navController, startDestination = Destinations.Pantalla1.route) {
        composable(Destinations.Pantalla1.route) {
            ApiListScreen(viwModel, navController)
        }
        composable(Destinations.Pantalla2.route) {
            FavoriteListScreen(viwModel, navController)
        }
        composable(Destinations.Pantalla3.route) {
            SettingsSc()
        }
        composable(Destinations.Pantalla11("").route) { backStackEntry ->
            val param = backStackEntry.arguments?.getString("myParameter") ?: ""
            DetailsSc(viwModel) {
                navController.popBackStack()
            }
        }
    }
}