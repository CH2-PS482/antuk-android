package com.antukcapstone.antuk.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun Headlines(
    titleHeadlinesText: String,
    smallHeadlinesText: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TitleHeadlines(text = titleHeadlinesText)
        SmallHeadlines(text = smallHeadlinesText)
    }
}

@Composable
fun TitleHeadlines(
    text: String
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 33.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = Color.Black
            ),
        )
    }

}

@Composable
fun SmallHeadlines(
    text: String
) {
    Box(modifier = Modifier.width(230.dp)) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                color = Color.Black,
            )
        )
    }

}

@Preview(showBackground = true)
@Composable
fun HeadlinesPreview() {
    AntukTheme {
        Headlines(titleHeadlinesText = "Please Check Your Message", smallHeadlinesText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
    }
}