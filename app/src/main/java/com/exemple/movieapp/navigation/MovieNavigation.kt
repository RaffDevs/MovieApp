package com.exemple.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exemple.movieapp.screens.details.DetailScreen
import com.exemple.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation () {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {

        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController)
        }

        composable(
            MovieScreens.DetailScreen.name+"/{movie}",
            arguments = listOf(
                navArgument(name = "movie") { type = NavType.StringType}
            )
        ) { backStackEntry ->
            DetailScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}