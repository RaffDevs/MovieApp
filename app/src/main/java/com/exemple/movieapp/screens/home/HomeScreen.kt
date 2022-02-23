package com.exemple.movieapp.screens.home

import android.util.Log
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
import com.exemple.movieapp.MyAppBar
import com.exemple.movieapp.model.Movie
import com.exemple.movieapp.model.getMovies
import com.exemple.movieapp.navigation.MovieScreens
import com.exemple.movieapp.widgets.MovieRow
import com.google.gson.Gson

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
    movieList: List<Movie> = getMovies()
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
        LazyColumn{
            items(items = movieList) { movie ->
                MovieRow(movie) {
                    val movieJson = Gson().toJson(movie)
                    Log.d("Movie", movieJson)
                    navController.navigate(
                        route = MovieScreens.DetailScreen.name + "?movie={movie}"
                            .replace("{movie}", movieJson)
                    )
                }
            }
        }
    }
}