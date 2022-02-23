package com.exemple.movieapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exemple.movieapp.model.Movie
import com.exemple.movieapp.screens.details.DetailScreen
import com.exemple.movieapp.screens.home.HomeScreen
import com.google.gson.Gson

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
            MovieScreens.DetailScreen.name+"?movie={movie}",
            arguments = listOf(
                navArgument(name = "movie") { type = NavType.StringType}
            )
        ) { backStackEntry ->
            val movieJson = backStackEntry.arguments?.getString("movie")
            val movieObject = Gson().fromJson<Movie>(movieJson, Movie::class.java)
            DetailScreen(
                navController = navController,
                movieObject
            )
        }
    }
}