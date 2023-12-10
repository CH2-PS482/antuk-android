package com.antukcapstone.antuk.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.components.ButtonPrimary
import com.antukcapstone.antuk.ui.components.ButtonSecondary
import com.antukcapstone.antuk.ui.components.Headlines
import com.antukcapstone.antuk.ui.components.SmallHeadlines
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun OnBoardingScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.hedgehog_sleep) ,
                    contentDescription = "Hedgehog Graphic",
                    modifier = Modifier
                        .requiredSize(160.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(100.dp))
            
            Column {
               SmallHeadlines(
                   text = stringResource(R.string.welcome_to),
               )
                Spacer(modifier = Modifier.height(1.dp))
                Headlines(
                    titleHeadlinesText = stringResource(R.string.app_name),
                    smallHeadlinesText = stringResource(R.string.antuk_desc),
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                SmallHeadlines(text = stringResource(R.string.get_started))
                ButtonPrimary(text = stringResource(R.string.log_in), onClick = {})
                ButtonSecondary(text = stringResource(R.string.create_account), onClick = {})
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    AntukTheme {
        OnBoardingScreen()
    }
}