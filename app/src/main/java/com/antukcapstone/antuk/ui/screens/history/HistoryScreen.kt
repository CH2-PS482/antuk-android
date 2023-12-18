package com.antukcapstone.antuk.ui.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.screens.components.Headlines
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun HistoryScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { }
                )

                Spacer(modifier = Modifier.height(15.dp))

                Headlines(
                    titleHeadlinesText = stringResource(R.string.history),
                    smallHeadlinesText = stringResource(R.string.history_desc),
                )

                Spacer(modifier = Modifier.height(35.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "No History Yet",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_regular))
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    AntukTheme {
//        HistoryScreen(navController)
    }
}