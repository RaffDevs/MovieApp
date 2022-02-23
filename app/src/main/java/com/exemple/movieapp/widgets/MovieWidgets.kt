package com.exemple.movieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.exemple.movieapp.model.Movie
import com.exemple.movieapp.model.getMovies


@Composable
fun MovieRow(movie: Movie, onClick: (id: String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(130.dp)
            .clickable { onClick(movie.id) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = movie.images[0]
                    ),
                    contentDescription = "Movie Poster"
                )
            }

            Column(
                Modifier.padding(4.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = movie.director,
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = movie.year,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}
