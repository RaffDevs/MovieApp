package com.exemple.movieapp.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exemple.movieapp.model.Movie

@Composable
fun DetailScreen(navController: NavController, movie: Movie) {
    Scaffold(
        topBar = {
            DetailTopBar(navController)
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${movie.title} Screen"
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(onClick = {
                    navController.popBackStack();
                }) {
                    Text("Go Back")
                }
            }
        }
    }

}

@Composable
fun DetailTopBar(navController: NavController) {
    TopAppBar(
        title = { Text(text = "Details")},
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack();
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back"
                )
            }
        }
    )
}