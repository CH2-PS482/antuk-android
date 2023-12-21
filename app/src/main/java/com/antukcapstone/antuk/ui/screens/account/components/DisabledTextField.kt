package com.antukcapstone.antuk.ui.screens.account.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.theme.AntukTheme
import com.antukcapstone.antuk.ui.theme.LightGrey

@Composable
fun DisabledTextField(
    value: String,
    label: String,
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = label,
            fontFamily = FontFamily(Font(R.font.inter_regular)),
            fontSize = 14.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LightGrey,
                unfocusedBorderColor = LightGrey,
            ),
            value = value,
            singleLine = true,
            onValueChange = {},
            maxLines = 1,
            enabled = false
        )
    }
}

@Preview
@Composable
fun DisabledTextFieldPreview() {
    AntukTheme {
        DisabledTextField(value = "John Doe" , label = "INFO" )
    }
}