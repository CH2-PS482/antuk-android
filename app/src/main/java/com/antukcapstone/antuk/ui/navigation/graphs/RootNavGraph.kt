package com.antukcapstone.antuk.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antukcapstone.antuk.AntukApp
import com.antukcapstone.antuk.MainViewModel
import com.antukcapstone.antuk.core.di.Injection
import com.antukcapstone.antuk.core.helper.ViewModelFactory
import com.antukcapstone.antuk.ui.navigation.Screens

@Composable
fun RootNavGraph(
    activity: androidx.core.app.ComponentActivity,
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAntukRepository(LocalContext.current))
    )
) {

    val loginState by viewModel.loginState.collectAsState()

    val startDestination = remember {
        if (loginState?.fullName?.isNotEmpty() == true) {
            Screens.AppRoute.route
        } else {
            Screens.AuthRoute.route
        }
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