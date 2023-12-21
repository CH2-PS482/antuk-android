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
import androidx.compose.ui.unit.dp
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
    value: String ,
    onValueChange:(String) -> Unit,
    label: String,
    placeholder: String,
    keyboardOptions: KeyboardOptions

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
            value = value,
            singleLine = true,
            maxLines = 1,
            onValueChange = { onValueChange( it) },
        )
    }
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String
) {

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
            value = value,
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
              onValueChange(it)
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



