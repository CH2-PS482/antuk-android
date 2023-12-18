package com.antukcapstone.antuk.ui.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.antukcapstone.antuk.ui.navigation.Screens
import com.antukcapstone.antuk.ui.screens.account.login.LoginScreen
import com.antukcapstone.antuk.ui.screens.account.register.RegisterScreen
import com.antukcapstone.antuk.ui.screens.onboarding.OnBoardingScreen

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(
        startDestination = Screens.OnboardingScreenRoute.route, route = Screens.AuthRoute.route
    ) {
        composable(route = Screens.OnboardingScreenRoute.route) {
            OnBoardingScreen(
                toLogin = {navController.navigateToSingleTop(Screens.LoginScreenRoute.route)},
                toRegister = { navController.navigateToSingleTop(Screens.RegisterScreenRoute.route)}
            )
        }
        composable(route = Screens.LoginScreenRoute.route) {
            LoginScreen(
                onLogin = {navController.navigateToSingleTop(Screens.AppRoute.route)},
                toRegister = {navController.navigateToSingleTop(Screens.RegisterScreenRoute.route)}
            )
        }
        composable(route = Screens.RegisterScreenRoute.route) {
            RegisterScreen(
                onRegister = {navController.navigateToSingleTop(Screens.LoginScreenRoute.route)},
                toLogin = {navController.navigateToSingleTop(Screens.LoginScreenRoute.route)}
            )
        }
    }
}
