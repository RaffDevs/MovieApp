package com.exemple.movieapp.navigation

import java.lang.IllegalArgumentException

enum class MovieScreens {
    HomeScreen,
    DetailScreen;

    object DetailsRoutes {
        val main = "${DetailScreen.name}/{movie}"
    }

    companion object {
        fun fromRoute(route: String?): MovieScreens {
            return when(route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not found!")
            }
        }
    }
}