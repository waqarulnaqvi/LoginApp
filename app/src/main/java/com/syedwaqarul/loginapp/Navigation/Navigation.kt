package com.syedwaqarul.tipcalculator.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.syedwaqarul.loginapp.ui.theme.SplashScreen.SplashScreen
import com.syedwaqarul.loginapp.ui.theme.layouts.AccountCreate
import com.syedwaqarul.loginapp.ui.theme.layouts.LoginScreen


@Composable
fun Navigation(navHostController: NavHostController) {//navHostController is a jetpack compose type controller

    NavHost(
        navController = navHostController,
        startDestination = Navigationitems.splashScreen.route
    )
    {

        composable(Navigationitems.splashScreen.route)
        {
            SplashScreen(navHostController)
        }

        composable(Navigationitems.acountCreate.route) {
            AccountCreate(navHostController)
        }
        composable(Navigationitems.myComponents.route) {

             LoginScreen(navHostController)
        }
//        composable(Navigationitems.tipCalculator.route)
//        {
//            TipTimeLayout()
//        }
    }


}

