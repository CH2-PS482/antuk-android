package com.antukcapstone.antuk.ui.screens.account.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.antukcapstone.antuk.R

@Composable
fun ClickableText(
    text: String,
    hyperlink: String,
    onClick: () -> Unit,
) {
  Row (

  ) {
      Text(
          text = text,
          color = Color.Black,
          style = TextStyle(
          fontFamily = FontFamily(Font(R.font.inter_regular)),
        )
      )
      Spacer(modifier = Modifier.width(5.dp))
      Text(
          text = hyperlink,
          color = Color.Black,
          fontWeight = FontWeight.Bold,
          style = TextStyle(
              fontFamily = FontFamily(Font(R.font.inter_bold)),
              textDecoration = TextDecoration.Underline
          ),
          modifier = Modifier.clickable {
              onClick
          }
      )

  }
}