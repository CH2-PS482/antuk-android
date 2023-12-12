package com.antukcapstone.antuk.ui.screens.home.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antukcapstone.antuk.R



@Composable
fun CardHeadlines(
    bigHeadline: String,
    smallHeadline: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()

        ) {
            Text(
                text = bigHeadline,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    color = Color.White
                ),
                modifier = Modifier.height(30.dp)
            )

            Text(
                text = smallHeadline,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    color = Color.White,
                )
            )
        }

    }
}

@Composable
fun CardButton(
    textButton: String,
    iconButton: Painter,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 10.dp),
        modifier = Modifier
            .requiredWidth(width = 178.dp)
            .requiredHeight(height = 50.dp)
    ) {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = iconButton,
                contentDescription = "",
                modifier = Modifier
                    .requiredSize(24.dp),
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(9.dp))

        Text(
            text = textButton,
            style = TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = Color.Black,
                ),

            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp),
            )
    }
}

