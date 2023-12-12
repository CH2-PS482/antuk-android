package com.antukcapstone.antuk.ui.screens.account.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun ButtonProfile(
    text: String,
    modifier: Modifier = Modifier,
    icon: Painter,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RoundedCornerShape(size = 10.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = icon,
                contentDescription = "",
                tint = Color.Black )

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_semibold)),
                    color = Color.Black,
                ),
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ButtonProfilePreview() {
    AntukTheme {
        ButtonProfile(text = "Edit Profile Information", icon = painterResource(R.drawable.information), onClick = {})
    }
}
