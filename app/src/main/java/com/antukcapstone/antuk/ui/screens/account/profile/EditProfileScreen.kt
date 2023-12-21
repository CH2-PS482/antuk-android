package com.antukcapstone.antuk.ui.screens.account.profile


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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.core.di.Injection
import com.antukcapstone.antuk.core.helper.ViewModelFactory
import com.antukcapstone.antuk.ui.screens.components.ButtonPrimary
import com.antukcapstone.antuk.ui.screens.components.Headlines
import com.antukcapstone.antuk.ui.screens.account.components.InputTextField
import com.antukcapstone.antuk.ui.theme.AntukTheme


@Composable
fun EditProfileScreen(
    viewModel: EditProfileViewModel = viewModel(factory = ViewModelFactory(
        Injection.provideAntukRepository(
        LocalContext.current))
    ),
    onSave:() -> Unit
) {
    val context = LocalContext.current
    val sessionData by viewModel.getLoggedInUser().observeAsState()

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
                    titleHeadlinesText = stringResource(R.string.edit_profile),
                    smallHeadlinesText = stringResource(R.string.edit_profile_desc),
                )

                Spacer(modifier = Modifier.height(35.dp))

                sessionData?.let {
                    InputTextField(
                        value = it.fullName,
                        onValueChange = {input ->
                            viewModel.fullName = input
                        },
                        label = stringResource(R.string.full_name),
                        placeholder = stringResource(R.string.your_full_name),
                        keyboardOptions = KeyboardOptions.Default
                    )
                }


                Spacer(modifier = Modifier.height(15.dp))


                sessionData?.let {
                    InputTextField(
                        value = it.phoneNumber,
                        onValueChange = {input ->
                            viewModel.phoneNumber = input
                        },
                        label = stringResource(R.string.phone_number),
                        placeholder = stringResource(R.string.phone_number_placeholder),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                }

                Spacer(modifier = Modifier.height(21.dp))

                ButtonPrimary(text = stringResource(R.string.save), onClick = {
                    onSave()
                })
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun EditProfileScreenPreview() {
    AntukTheme {
//        EditProfileScreen()
    }
}