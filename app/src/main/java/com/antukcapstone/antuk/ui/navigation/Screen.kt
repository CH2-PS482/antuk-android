package com.antukcapstone.antuk.ui.navigation

sealed class Screens(val route: String) {
    data object OnboardingScreenRoute: Screens(route = "Onboarding")
    data object LoginScreenRoute: Screens(route = "Login")
    data object RegisterScreenRoute: Screens(route="Register")
    data object HomeScreenRoute: Screens(route = "Home")

    data object RecognitionScreenRoute: Screens(route = "Recognition")
    data object GuideScreenRoute: Screens(route = "Guide")
    data object ProfileScreenRoute: Screens(route = "Profile")
    data object HistoryScreenRoute: Screens(route = "History")
    data object EditProfileScreenRoute: Screens(route = "EditProfile")
    data object ResetPasswordScreenRoute: Screens(route = "ResetPassword")
    data object PasswordChangedScreenRoute: Screens(route = "PasswordChanged")


    data object AuthRoute: Screens(route = "Auth")
    data object AppRoute: Screens(route="App")
    data object UserRoute: Screens(route="User")

}