package com.antukcapstone.antuk.ui.screens.account.password

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.core.di.Injection
import com.antukcapstone.antuk.core.helper.ViewModelFactory
import com.antukcapstone.antuk.ui.screens.components.ButtonPrimary
import com.antukcapstone.antuk.ui.screens.components.Headlines
import com.antukcapstone.antuk.ui.screens.account.components.PasswordTextField
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun ResetPasswordScreen(
    onReset:() -> Unit,
    context: Context = LocalContext.current,
    viewModel: ResetPasswordViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAntukRepository(context))
    )
) {

    val context: Context = LocalContext.current

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var confirmPassword by rememberSaveable {
        mutableStateOf("")
    }

    val sendState by viewModel.send.observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
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
                    titleHeadlinesText = stringResource(R.string.reset_password),
                    smallHeadlinesText = stringResource(R.string.reset_password_desc),
                )

                Spacer(modifier = Modifier.height(35.dp))

                PasswordTextField(
                    value = viewModel.password,
                    onValueChange = {input ->
                        viewModel.password = input
                    },
                    label = stringResource(R.string.new_password), placeholder = stringResource(
                    R.string.password_placeholder
                ) )

                Spacer(modifier = Modifier.height(15.dp))

                PasswordTextField(
                    value = viewModel.confirmPassword,
                    onValueChange = {input ->
                        viewModel.confirmPassword = input
                    },
                    label = stringResource(R.string.confirm_password), placeholder = stringResource(
                    R.string.confirm_password_placeholder
                ) )

                Spacer(modifier = Modifier.height(30.dp))

                ButtonPrimary(text = stringResource(R.string.reset_password), onClick = {
                    viewModel.sendResetPasswordData(password, confirmPassword)
                    onReset()
                })
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ResetPasswordScreenPreview() {
    AntukTheme {
//        ResetPasswordScreen()
    }
}