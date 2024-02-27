package com.syedwaqarul.loginapp.ui.theme.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.syedwaqarul.loginapp.R
import com.syedwaqarul.loginapp.ui.theme.LoginAppTheme
import com.syedwaqarul.tipcalculator.Navigation.Navigationitems

@Composable
fun LoginScreen(navHostController:NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = .9f),
                        MaterialTheme.colorScheme.primary.copy(alpha = .1f)

                    )
                )
            )
    ) {
        Spacer(modifier = Modifier.height(120.dp))

        Image(
            painter = painterResource(id = R.drawable.clouds), contentDescription = "",
            modifier = Modifier.size(130.dp)
        )
        Spacer(modifier = Modifier.height(70.dp))
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        UserInputField(
            onValueChange = {email=it},
            value = email
        )
        UserInputField(
            label = "Password",
            icon = Icons.Default.Lock,
            isfocused = true,
            onValueChange = {password=it},
            value = password
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(26.dp, 0.dp)
                .padding(top = 22.dp)
                .height(56.dp),
            colors = ButtonDefaults
                .buttonColors(
                    containerColor =
                    if (isSystemInDarkTheme()) Color.Yellow else Color.Blue,
                    contentColor =
                    if (isSystemInDarkTheme()) Color.Blue else Color.White
                )

                ) {
            Text(
                text = "Sign In",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }

        Spacer(modifier =Modifier.weight(1f) )
        Row(

        ) {
            Text(
                text = "Don't have an account?",
                fontWeight = FontWeight.Medium,
                color=MaterialTheme.colorScheme.onSurface.copy(alpha=.8f))


            Text(
                text = "Sign Up",
                modifier = Modifier
                    .padding(start = 3.dp)
                    .clickable {
                        navHostController.navigate(Navigationitems.acountCreate.route)

                    },
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
//                onClick = { /*TODO*/ }

            )


        }
        Spacer(modifier = Modifier.height(60.dp))

    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun LoginScreenprev() {
//    LoginAppTheme {
//        LoginScreen()
//    }
//
//
//}

@Composable
fun UserInputField(
    label: String = "Email",
    icon: ImageVector = Icons.Default.Email,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isfocused: Boolean = false,
    modifier: Modifier = Modifier,
) {


    TextField(

        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),


        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                color = if (isfocused) Color.Blue else Color.Black
            )
        },
        leadingIcon = {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .padding(end = 8.dp),
//                tint = if (isfocused) Color.Blue else Color.Gray
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(25.dp, 10.dp),
//        trailingIcon = {
//            val passwordIcon = if (passwordVisible) {
//                AppIcons.PasswordEyeVisible
//            } else {
//                AppIcons.PasswordEyeInvisible
//            }
//            val description = if (passwordVisible) {
//                "Hide Password"
//            } else {
//                "Show Password"
//            }
//            IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                Icon(imageVector = passwordIcon, contentDescription = description)
//            }
    )
}