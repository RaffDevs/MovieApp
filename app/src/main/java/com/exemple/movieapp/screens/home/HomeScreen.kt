package com.exemple.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exemple.movieapp.MovieRow
import com.exemple.movieapp.MyAppBar
import com.exemple.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyAppBar(navController)
        },
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Avatar",
        "Spider Man",
        "Avengers",
        "Iron Man",
        "Batman",
        "Thor",
        "Man of Steel"
    )
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
        LazyColumn{
            items(items = movieList) { movie ->
                MovieRow(movie) {
                    navController.navigate(
                        route = MovieScreens.DetailScreen.name + "/$movie",
                    )
                }
            }
        }
    }
}