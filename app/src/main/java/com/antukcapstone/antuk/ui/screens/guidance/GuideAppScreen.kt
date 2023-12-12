package com.antukcapstone.antuk.ui.screens.guidance

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.components.Headlines
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun GuideAppScreen() {
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
                titleHeadlinesText = stringResource(R.string.guide_app),
                smallHeadlinesText = stringResource(R.string.guide_app_desc),
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(height = 500.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color.White)
                    .border(
                        border = BorderStroke(2.dp, Color.Black),
                        shape = RoundedCornerShape(15.dp)
                    )
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                ) {
                    Text(
                        text = stringResource(R.string.start_driving),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = stringResource(R.string.guide_step),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 19.sp,
                            fontFamily = FontFamily(Font(R.font.inter_regular))
                        )
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun GuideAppScreenPreview() {
    AntukTheme {
        GuideAppScreen()
    }
}