package com.example.apilist.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: Destinations,
    val index: Int
)