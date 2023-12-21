package com.antukcapstone.antuk.ui.screens.account.login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ComponentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antukcapstone.antuk.MainActivity
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.core.data.local.datastore.UserModel
import com.antukcapstone.antuk.core.data.remote.retrofit.ApiResult
import com.antukcapstone.antuk.core.di.Injection
import com.antukcapstone.antuk.core.helper.ViewModelFactory
import com.antukcapstone.antuk.ui.navigation.BackIconNav
import com.antukcapstone.antuk.ui.screens.components.ButtonPrimary
import com.antukcapstone.antuk.ui.screens.components.Headlines
import com.antukcapstone.antuk.ui.screens.account.components.ClickableText
import com.antukcapstone.antuk.ui.screens.account.components.InputTextField
import com.antukcapstone.antuk.ui.screens.account.components.PasswordTextField
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun LoginScreen(
    context: Context = LocalContext.current,
    viewModel: LoginViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAntukRepository(context))
    ),
    onLogin:() -> Unit,
    toRegister:() -> Unit,
) {
    val context = LocalContext.current

    var showDialog by remember { mutableStateOf(false) }

    var showLoading by remember {
        mutableStateOf(false)
    }
    val focusRequester = remember {FocusRequester()}

    val isFocused by remember { mutableStateOf(false) }

    val wasFocused = remember {isFocused}

    val sendState by viewModel.send.observeAsState()

    when (val apiResult = sendState) {
        is ApiResult.Loading -> {
            showLoading = true
        }

        is ApiResult.Success -> {
            showDialog = true
            val user = UserModel(
                idUser = apiResult.data.loginData?.idUser.toString(),
                phoneNumber = apiResult.data.loginData?.phoneNumber.toString(),
                fullName = apiResult.data.loginData?.fullName.toString(),
                token = apiResult.data.loginData?.token.toString(),
//                isLoggedIn = true
            )
            viewModel.saveLoggedInUser(user)
        }
        is ApiResult.Error -> {
            showLoading = false
            Toast.makeText(context, "Nomor Telepon atau Password Tidak Sesuai", Toast.LENGTH_LONG).show()
        }
        else -> {}
    }

    LaunchedEffect(true ) {
        if (wasFocused) {
            focusRequester.requestFocus()
        }
    }


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
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(10.dp))
                
                BackIconNav()

                Spacer(modifier = Modifier.height(15.dp))

                Headlines(
                    titleHeadlinesText = stringResource(R.string.log_in),
                    smallHeadlinesText = stringResource(R.string.log_in_desc),
                )

                Spacer(modifier = Modifier.height(35.dp))

                InputTextField(
                    value = viewModel.phoneNumber,
                    onValueChange = {input ->
                        viewModel.phoneNumber = input
                    },
                    label = stringResource(R.string.phone_number),
                    placeholder = stringResource(R.string.phone_number_placeholder),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )

                Spacer(modifier = Modifier.height(25.dp))
                
                PasswordTextField(
                    value = viewModel.password,
                    onValueChange = {input ->
                        viewModel.password = input
                    },
                    label = stringResource(R.string.password), placeholder = stringResource(
                    R.string.password_placeholder
                ) )

                Spacer(modifier = Modifier.height(15.dp))

                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ClickableText(
                        text = "", hyperlink = stringResource(R.string.forgot_password), onClick = {},
                    )
                }


                Spacer(modifier = Modifier.height(45.dp))

                ButtonPrimary(
                    text = stringResource(R.string.log_in),
                    onClick = {
                        if(viewModel.phoneNumber.isEmpty() || viewModel.password.isEmpty()) {
                            Toast.makeText(context, "Nomor Telepon dan Password Tidak Boleh Kosong", Toast.LENGTH_LONG).show()
                        }

                       else if(viewModel.phoneNumber.length <= 10) {
                            Toast.makeText(context, "Nomor Telepon Minimal 10 Digit", Toast.LENGTH_LONG).show()
                        }
                        else if(viewModel.password.length <= 8) {
                            Toast.makeText(context, "Password minimal 8 Karakter", Toast.LENGTH_SHORT).show()
                        }
                        viewModel.sendLoginData(viewModel.phoneNumber, viewModel.password)
//                        onLogin()
                    })

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = {
                            // Handle dialog dismissal if needed
                            showDialog = false
                        },
                        title = {
                            Text("Login Successful")
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                    val intent = Intent(context, MainActivity::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                    context.startActivity(intent)
                                    (context as? ComponentActivity)?.finish()
                                    onLogin()
                                },

                                colors = ButtonDefaults.buttonColors(Color.Black),
                                shape = RoundedCornerShape(size = 10.dp),
                            ) {
                                Text("Ok")
                            }
                        },
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ClickableText(
                        text = stringResource(R.string.dont_have_account),
                        hyperlink = stringResource(R.string.create_account),
                        onClick = {
                            toRegister()
                        }
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_2)
@Composable
fun LoginScreenPreview() {
    AntukTheme {
//        LoginScreen(navController = navContoller)
    }
}