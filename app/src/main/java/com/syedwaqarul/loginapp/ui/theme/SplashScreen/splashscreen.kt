package com.syedwaqarul.loginapp.ui.theme.SplashScreen

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.syedwaqarul.loginapp.R
import com.syedwaqarul.loginapp.ui.theme.LoginAppTheme
import com.syedwaqarul.tipcalculator.Navigation.Navigationitems
import kotlinx.coroutines.delay

@Composable
//fun SplashScreen() {
fun SplashScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxSize()

    ) {
        var scale: Animatable<Float, AnimationVector1D> = remember {
            Animatable(0.0f)
        }

        LaunchedEffect(key1 = true)
        {
            scale.animateTo(
                targetValue = 0.0f,
                animationSpec = tween(800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
            delay(1000)
            navHostController.navigate(Navigationitems.myComponents.route)
            {
                popUpTo(Navigationitems.splashScreen.route)
                {
                    inclusive = true
                }
            }
        }
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
            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = R.drawable.android), contentDescription = "",
                modifier = Modifier.size(130.dp),
//                tint =  Color.White// Icon tint color only helpful when you use Icon instead of Image.



            )
            Spacer(modifier = Modifier.height(70.dp))
            Text(
                text = "Jetpack\nCompose",
//                color = Color.Yellow,
                modifier = Modifier
                    .background(Color.Yellow,
                        shape=MaterialTheme.shapes.extraLarge)
                    .padding(28.dp, 20.dp),
                fontWeight = FontWeight.ExtraBold,
//    shape=MaterialTheme.shapes.extraLarge,
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun SplashScreenprev() {
//    LoginAppTheme {
//        SplashScreen()
//    }
//
//}