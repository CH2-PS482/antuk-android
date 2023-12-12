package com.antukcapstone.antuk.ui.screens.account.createaccount

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.components.ButtonPrimary
import com.antukcapstone.antuk.ui.components.Headlines
import com.antukcapstone.antuk.ui.screens.account.components.ClickableText
import com.antukcapstone.antuk.ui.screens.account.components.InputTextField
import com.antukcapstone.antuk.ui.screens.account.components.PasswordTextField
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun CreateAccountScreen() {
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
           Column (
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
                    titleHeadlinesText = stringResource(R.string.create_account),
                    smallHeadlinesText = stringResource(R.string.create_account_desc),
                )

                Spacer(modifier = Modifier.height(35.dp))

                InputTextField(
                    label = stringResource(R.string.full_name),
                    placeholder = stringResource(R.string.your_full_name),
                    keyboardOptions = KeyboardOptions.Default
                )

                Spacer(modifier = Modifier.height(25.dp))

                InputTextField(
                    label = stringResource(R.string.phone_number),
                    placeholder = stringResource(R.string.phone_number_placeholder),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(25.dp))

                PasswordTextField(label = stringResource(R.string.password), placeholder = stringResource(
                    R.string.password_placeholder
                ) )

                Spacer(modifier = Modifier.height(25.dp))

                PasswordTextField(label = stringResource(R.string.confirm_password), placeholder = stringResource(
                    R.string.confirm_password_placeholder
                ) )

                Spacer(modifier = Modifier.height(45.dp))

                ButtonPrimary(text = stringResource(R.string.create_account), onClick = {})

                Spacer(modifier = Modifier.height(17.dp))

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ClickableText(text = stringResource(R.string.already_have_account), hyperlink = stringResource(R.string.log_in), onClick = {},
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun CreateAccountScreenPreview() {
    AntukTheme {
        CreateAccountScreen()
    }
}