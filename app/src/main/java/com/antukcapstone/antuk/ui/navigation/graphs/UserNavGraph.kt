package com.antukcapstone.antuk.ui.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.antukcapstone.antuk.ui.navigation.Screens
import com.antukcapstone.antuk.ui.screens.account.password.PasswordChanged
import com.antukcapstone.antuk.ui.screens.account.password.ResetPasswordScreen
import com.antukcapstone.antuk.ui.screens.account.profile.EditProfileScreen
import com.antukcapstone.antuk.ui.screens.account.profile.ProfileScreen

fun NavGraphBuilder.userGraph(navController: NavController) {
    navigation(
        startDestination = Screens.ProfileScreenRoute.route,
        route = Screens.UserRoute.route
    ) {
        composable(route = Screens.ProfileScreenRoute.route) {
            ProfileScreen(
                toEditProfile = { navController.navigate(Screens.EditProfileScreenRoute.route) },
                toResetPassword = { navController.navigate(Screens.ResetPasswordScreenRoute.route) },
            )
        }

        composable(route=Screens.EditProfileScreenRoute.route) {
            EditProfileScreen (
                onSave = {navController.navigateToSingleTop(Screens.ProfileScreenRoute.route)}
            )
        }

        composable(route = Screens.ResetPasswordScreenRoute.route) {
            ResetPasswordScreen(
                onReset = {navController.navigateToSingleTop(Screens.PasswordChangedScreenRoute.route)}
            )
        }

        composable(route = Screens.PasswordChangedScreenRoute.route) {
            PasswordChanged (
                toHome = {
                    navController.navigateToSingleTop(Screens.AppRoute.route)
                }
            )
        }
    }
}