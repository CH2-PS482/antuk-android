package com.antukcapstone.antuk.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.antukcapstone.antuk.ui.navigation.Screens
import com.antukcapstone.antuk.ui.screens.guidance.GuideAppScreen
import com.antukcapstone.antuk.ui.screens.history.HistoryScreen
import com.antukcapstone.antuk.ui.screens.home.HomeScreen
import com.antukcapstone.antuk.ui.screens.recognition.RecognitionScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
  NavHost(
      navController = navController ,
      route = Screens.AppRoute.route,
      startDestination = Screens.HomeScreenRoute.route )
    {
        composable(route = Screens.HomeScreenRoute.route) {
            HomeScreen(
                toRecognition = {navController.navigate(Screens.RecognitionScreenRoute.route)},
                toGuide = {navController.navigate(Screens.GuideScreenRoute.route
                )}
            )
        }

        composable(route = Screens.RecognitionScreenRoute.route) {
            RecognitionScreen()
        }

        composable(route = Screens.GuideScreenRoute.route) {
            GuideAppScreen()
        }

        userGraph(navController)

        composable(route = Screens.HistoryScreenRoute.route) {
            HistoryScreen(navController = navController)
        }
    }
}