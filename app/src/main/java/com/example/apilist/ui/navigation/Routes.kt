// Kotlin
package com.example.apilist.ui.navigation

sealed class Destinations(val route: String) {
    object Pantalla1 : Destinations("pantalla1")
    object Pantalla2 : Destinations("pantalla2")
    object Pantalla3 : Destinations("pantalla3")
    data class Pantalla11(val myParameter: String) : Destinations("pantalla11/{myParameter}") {
        fun createRoute() = "pantalla11/$myParameter"
    }
}