package com.syedwaqarul.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

import com.syedwaqarul.loginapp.ui.theme.LoginAppTheme
import com.syedwaqarul.loginapp.ui.theme.layouts.LoginScreen
import com.syedwaqarul.tipcalculator.Navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                MyApp()

            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        it
        var navHostController = rememberNavController()
        Navigation(navHostController = navHostController)
    }


}
