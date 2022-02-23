package com.exemple.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exemple.movieapp.navigation.MovieNavigation
import com.exemple.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        content()
    }
}

@Composable
fun MyAppBar(navController: NavController) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 5.dp,
        title = {
            Text("Movies")
        },
    ) 
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTheme {
    }
}