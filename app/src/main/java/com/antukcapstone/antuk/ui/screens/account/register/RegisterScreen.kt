package com.antukcapstone.antuk.ui.screens.account.register

import android.content.Context
import android.content.Intent
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ComponentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antukcapstone.antuk.MainActivity
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.core.data.remote.retrofit.ApiResult
import com.antukcapstone.antuk.core.di.Injection
import com.antukcapstone.antuk.core.helper.ViewModelFactory
import com.antukcapstone.antuk.ui.screens.components.ButtonPrimary
import com.antukcapstone.antuk.ui.screens.components.Headlines
import com.antukcapstone.antuk.ui.screens.account.components.ClickableText
import com.antukcapstone.antuk.ui.screens.account.components.InputTextField
import com.antukcapstone.antuk.ui.screens.account.components.PasswordTextField
import com.antukcapstone.antuk.ui.theme.AntukTheme

@Composable
fun RegisterScreen(
    onRegister:() -> Unit,
    toLogin:() -> Unit,
    context: Context = LocalContext.current,
    viewModel: RegisterViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAntukRepository(context))
    )
) {
    val context: Context = LocalContext.current

    var fullName by rememberSaveable {
        mutableStateOf("")
    }

    var phoneNumber by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var confirmPassword by rememberSaveable {
        mutableStateOf("")
    }


    var showDialog by remember { mutableStateOf(false) }

    var showPassword by remember { mutableStateOf(false) }

    val focusRequester = remember { FocusRequester() }

    var isFocused by remember { mutableStateOf(false) }

    val isLoading by viewModel.isLoading.observeAsState(initial = false)

    val sendState by viewModel.send.observeAsState()

    val wasFocused = remember {
        isFocused
    }

    when (val apiResult = sendState) {
        is ApiResult.Loading -> {}
        is ApiResult.Success -> {

            showDialog = true
        }
        is ApiResult.Error -> {

            showDialog = false
            Toast.makeText(context, "Tidak Sesuai", Toast.LENGTH_LONG).show()
        }
        else -> {}
    }



    LaunchedEffect(true) {
        if(wasFocused) {
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
                    value = viewModel.fullName,
                    onValueChange = {input ->
                        viewModel.fullName = input
                    },
                    label = stringResource(R.string.full_name),
                    placeholder = stringResource(R.string.your_full_name),
                    keyboardOptions = KeyboardOptions.Default
                )

                Spacer(modifier = Modifier.height(25.dp))

                InputTextField(
                    value = viewModel.phoneNumber,
                    onValueChange = {input ->
                        viewModel.phoneNumber = input
                    },
                    label = stringResource(R.string.phone_number),
                    placeholder = stringResource(R.string.phone_number_placeholder),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(25.dp))

                PasswordTextField(
                    value = viewModel.password,
                    onValueChange = {input ->
                        viewModel.password = input
                    },
                    label = stringResource(
                    R.string.password), placeholder = stringResource(
                    R.string.password_placeholder
                ) )

                Spacer(modifier = Modifier.height(25.dp))

                PasswordTextField(
                    value = viewModel.confirmPassword,
                    onValueChange = {input ->
                        viewModel.confirmPassword = input
                    },
                    label = stringResource(R.string.confirm_password), placeholder = stringResource(
                    R.string.confirm_password_placeholder
                ) )

                Spacer(modifier = Modifier.height(45.dp))

                ButtonPrimary(
                    text = stringResource(R.string.create_account),
                    onClick = {
                        if(viewModel.phoneNumber.length <= 10) {
                            Toast.makeText(context, "Nomor Telepon Minimal 10 Digit", Toast.LENGTH_LONG).show()
                        }
                        if(viewModel.password.length <= 8) {
                            Toast.makeText(context, "Password minimal 8 Karakter", Toast.LENGTH_SHORT).show()
                        }
//                       onRegister()
                        viewModel.sendRegisterData(
                            viewModel.fullName,
                            viewModel.phoneNumber,
                            viewModel.password,
                            viewModel.confirmPassword
                        )
                    }
                )

               if(showDialog) {
                   AlertDialog(
                       onDismissRequest = {
                           showDialog = false
                       },
                       title = {
                           Text(text = "Buat Akun Berhasil")
                       },
                       text = {
                           Text(text = "Silahkan Login Akun")
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
                                   onRegister()
                               },
                               colors = ButtonDefaults.buttonColors(Color.Black),
                               shape = RoundedCornerShape(size = 10.dp),
                           ) {
                               Text("Ok")
                           }
                       },
                   )
               }

                Spacer(modifier = Modifier.height(17.dp))

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ClickableText(
                        text = stringResource(R.string.already_have_account),
                        hyperlink = stringResource(R.string.log_in),
                        onClick = {
                           toLogin()
                        },
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

    }
}