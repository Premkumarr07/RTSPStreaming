package com.example.livestreaming.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.livestreaming.screens.HelpScreen
import com.example.livestreaming.screens.HomeScreen
import com.example.livestreaming.screens.ProfileScreen
import com.example.livestreaming.VideoStreamScreen
import androidx.compose.foundation.layout.PaddingValues

@Composable
fun Navigation(paddingValues: PaddingValues) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues) // Apply padding here
    ) {
        composable("home") { HomeScreen(navController) }
        composable("help") { HelpScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("stream") { VideoStreamScreen(navController) }
    }
}
