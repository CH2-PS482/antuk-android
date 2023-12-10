package com.antukcapstone.antuk.ui.screens.account.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antukcapstone.antuk.ui.theme.AntukTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.antukcapstone.antuk.R
import com.antukcapstone.antuk.ui.theme.LightGrey


@Composable
fun InputTextField(
    label: String,
    placeholder: String,
    keyboardOptions: KeyboardOptions
) {
    val textValue = remember {
        mutableStateOf("")
    }

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
            placeholder = {
                    Text(
                        text = placeholder,
                        color = Color.Gray,
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontSize = 14.sp
                    )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LightGrey,
                unfocusedBorderColor = LightGrey,
            ),
            keyboardOptions = keyboardOptions,
            value = textValue.value,
            singleLine = true,
            onValueChange = {
                textValue.value = it
            },
        )
    }
}

@Composable
fun PasswordTextField(
    label: String,
    placeholder: String
) {
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }
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
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color.Gray,
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    fontSize = 14.sp
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LightGrey,
                unfocusedBorderColor = LightGrey,
            ),
            value = password.value,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                password.value = it
            },
            trailingIcon = {
                val icomImage = if (passwordVisible.value)
                    Icons.Filled.Visibility else Icons.Filled.VisibilityOff

                var description = if (passwordVisible.value)
                    stringResource(R.string.hide_password) else stringResource(R.string.show_password)
                
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = icomImage, contentDescription = "")
                    
                }
            },
            visualTransformation = if(passwordVisible.value)
                VisualTransformation.None else PasswordVisualTransformation()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun InputFormPreview() {
    AntukTheme {
        InputTextField(label = "Label Form" , placeholder = "Your Value", keyboardOptions = KeyboardOptions.Default )
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    AntukTheme {
        PasswordTextField(label = "Password", placeholder = "Your Password")
    }
}

