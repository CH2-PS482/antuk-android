package com.antukcapstone.antuk.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.navigation.graphs.navigateToSingleTop
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun BottomBarScreen(
    navController: NavHostController
) {
   NavigationBar(
      modifier = Modifier,
      containerColor = Color.Transparent
   ) {
       val navBackStackEntry by navController
           .currentBackStackEntryAsState()
       val currentRoute = navBackStackEntry?.destination?.route

       val navigationItem = listOf(
           NavigationItem(
               title = stringResource(R.string.home),
               icon = painterResource(R.drawable.home),
               screen = Screens.HomeScreenRoute
           ),
           NavigationItem(
               title = stringResource(R.string.history),
               icon = painterResource(R.drawable.history),
               screen = Screens.HistoryScreenRoute
           ),
           NavigationItem(
               title = stringResource(R.string.profile),
               icon = painterResource(R.drawable.user),
               screen = Screens.ProfileScreenRoute
           )
       )

       navigationItem.map { item ->
           NavigationBarItem(
               icon = {
                   Icon(
                       painter = item.icon,
                       contentDescription = item.title
                   ) },
               label = {
                   Text(
                       item.title,
                       style = TextStyle(
                           fontFamily = FontFamily(Font(R.font.inter_regular))
                       )
               )},
               selected = currentRoute == item.screen.route,
               onClick = {
                   navController.navigateToSingleTop(item.screen.route) },
               )
       }
   }
}

@Preview
@Composable
fun BottomBarPreview() {
    AntukTheme {
        BottomBarScreen(navController = rememberNavController() )
    }
}