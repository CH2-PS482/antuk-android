package com.antukcapstone.antuk.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable

fun ButtonPrimary(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp) ,
        colors = ButtonDefaults.buttonColors(Color.Black),
        shape = RoundedCornerShape(size = 10.dp),

    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                color = Color.White,
            )
        )
    }
}

@Composable

fun ButtonRed(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp) ,
        colors = ButtonDefaults.buttonColors(Color(0xFFDF3939)),
        shape = RoundedCornerShape(size = 10.dp),

        ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                color = Color.White,
            )
        )
    }
}

@Composable
fun ButtonSecondary(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RoundedCornerShape(size = 10.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black)

    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonPrimaryPreview() {
    AntukTheme {
        ButtonPrimary(
            text = "Primary",
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonSecondaryPreview() {
    AntukTheme {
        ButtonSecondary(
            text = "Secondary",
            onClick = {}
        )
    }
}