package com.example.sabnewsletter.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.example.sabnewsletter.dashboard.DashboardView
import com.example.sabnewsletter.login.LoginView
import com.example.sabnewsletter.splash.SplashView

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