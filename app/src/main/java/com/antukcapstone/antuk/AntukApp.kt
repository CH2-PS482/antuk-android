package com.antukcapstone.antuk

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.antukcapstone.antuk.ui.navigation.BottomBarScreen
import com.antukcapstone.antuk.ui.navigation.Screens
import com.antukcapstone.antuk.ui.navigation.graphs.AppNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AntukApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {


    val screens = listOf(
        Screens.HomeScreenRoute,
        Screens.HistoryScreenRoute,
        Screens.ProfileScreenRoute
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val bottomBarDestination = screens.any{it.route == currentRoute}

    Scaffold(
        bottomBar = {
            if (bottomBarDestination) {
                BottomBarScreen(navController = navController)
            }
        }
    ) {
        AppNavGraph(navController = navController)
    }

}