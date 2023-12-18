package com.antukcapstone.antuk.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antukcapstone.antuk.AntukApp
import com.antukcapstone.antuk.ui.navigation.Screens

@Composable
fun RootNavGraph(
    navController: NavHostController = rememberNavController(),
    isLoggedin: Boolean
) {

    val startDestination = if (isLoggedin) {
        Screens.AppRoute.route
    } else {
       Screens.AuthRoute.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authGraph(navController)
//        appGraph(navController)
        composable(Screens.AppRoute.route) {
            AntukApp()
        }
    }
//    LaunchedEffect(Unit) {
//        if (!isLoggedin) {
//            navController.navigateToSingleTop(Screens.AuthRoute.route)
//        }
//    }
}

fun NavController.navigateToSingleTop(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}