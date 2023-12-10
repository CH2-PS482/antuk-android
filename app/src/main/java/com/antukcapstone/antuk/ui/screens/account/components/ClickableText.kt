package com.antukcapstone.antuk.ui.screens.account.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString

@Composable
fun ClickableText(
    text: String,
    hyperlink: String
) {
  Box(modifier = Modifier.fillMaxWidth()) {
      Text(text = buildAnnotatedString {
          append()
      })
  }
}