package com.auth.oschmidauthjwt.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import com.auth.oschmidauthjwt.dashboard.DashboardView
import com.auth.oschmidauthjwt.login.LoginView
import com.auth.oschmidauthjwt.splash.SplashView

@Composable
fun NavGraph(context: Context, navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavigationConstant.SPLASH){
        composable(NavigationConstant.SPLASH){ it->
            SplashView(navController)

        }
        composable(NavigationConstant.DASHOBARD){
            DashboardView(context,navController)
        }

        composable(NavigationConstant.LOGIN){
            LoginView(navController)
        }



    }


}