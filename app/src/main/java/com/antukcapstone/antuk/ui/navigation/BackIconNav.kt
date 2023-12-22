package com.antukcapstone.antuk.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.antukcapstone.antuk.R

@Composable
fun BackIconNav(
) {
    val navController = rememberNavController()
    Icon(
        painter = painterResource(R.drawable.arrow_back),
        contentDescription = "",
        modifier = Modifier
            .size(30.dp)
            .clickable { navController.popBackStack() }
    )
}