package com.syedwaqarul.loginapp.ui.theme.layouts


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.syedwaqarul.tipcalculator.Navigation.Navigationitems
import androidx.compose.material3.Icon as Icon1

//@Preview(showSystemUi = true)
@Composable
fun AccountCreate(navHostController: NavHostController) {


    LazyColumn {

        item {
            Icon1(
                imageVector = Icons.Default.ArrowDownward,
                contentDescription = "Back Button",
                modifier = Modifier
                    .rotate(90f)
                    .padding(30.dp)
            )
        }

        item {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Let's Get Started!",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.run { padding(bottom = 5.dp) }
                )

                Text(
                    text = "Create an account on Q Allure to get all features",
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 25.dp),
                    fontSize = 14.sp

                )

                UserInputField(
                    label = "Name",
                    icon = Icons.Default.AccountCircle,
                    isfocused = true
                )

                UserInputField()

                UserInputField(
                    label = "Phone",
                    icon = Icons.Default.PhoneAndroid
                )

                UserInputField(
                    label = "Password",
                    icon = Icons.Default.Lock
                )

                UserInputField(
                    label = "Confirm Password",
                    icon = Icons.Default.Lock
                )

                RoundedButton(text = "Create", navController = navHostController)

                Row(
                    modifier = Modifier.padding(top = 25.dp)
                ) {
                    Text(
                        text = "Already have an account?",
                        fontWeight = FontWeight.Medium,
                    )

                    Text(
                        modifier = Modifier.padding(start = 3.dp)

                            .clickable {
                                navHostController.navigate(Navigationitems.myComponents.route)

                            },
                        text = "Login here",
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,

                        )
                }
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }

}


@Composable
fun RoundedButton(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    text: String = "Log in",

    onclick: () -> Unit = { }
) {

    var buttonClicked by remember { mutableStateOf(false) }
    Button(
        onClick = {
//            buttonClicked = true

//            navController.navigate(Navigationitems.tipCalculator.route)


        },
        modifier = modifier
            .width(200.dp)
            .padding(20.dp)
        ,
        colors = ButtonDefaults
            .buttonColors(
                containerColor =
                if (isSystemInDarkTheme()) Color.Yellow else Color.Blue,
                contentColor =
                if (isSystemInDarkTheme()) Color.Blue else Color.White


            )

    ) {

        Text(text = text.uppercase())

    }



}