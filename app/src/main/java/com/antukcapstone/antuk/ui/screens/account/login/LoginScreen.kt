package com.antukcapstone.antuk.ui.screens.account.login

import android.text.style.ClickableSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.components.ButtonPrimary
import com.antukcapstone.antuk.ui.components.Headlines
import com.antukcapstone.antuk.ui.screens.account.components.InputTextField
import com.antukcapstone.antuk.ui.screens.account.components.PasswordTextField
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                )

                Spacer(modifier = Modifier.height(35.dp))

                Headlines(
                    titleHeadlinesText = stringResource(R.string.log_in),
                    smallHeadlinesText = stringResource(R.string.log_in_desc),
                    modifier = Modifier
                        .padding(top = 30.dp)
                )

                Spacer(modifier = Modifier.height(35.dp))

                InputTextField(
                    label = stringResource(R.string.phone_number),
                    placeholder = stringResource(R.string.phone_number_placeholder),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(25.dp))
                
                PasswordTextField(label = stringResource(R.string.password), placeholder = stringResource(
                    R.string.password_placeholder
                ) )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = stringResource(R.string.forgot_password),
                    modifier = Modifier
                        .align(Alignment.End),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_regular))
                    ),
                    textDecoration = TextDecoration.Underline
                )

                Spacer(modifier = Modifier.height(45.dp))

                ButtonPrimary(text = stringResource(R.string.log_in), onClick = {})


            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun LoginScreenPreview() {
    AntukTheme {
        LoginScreen()
    }
}