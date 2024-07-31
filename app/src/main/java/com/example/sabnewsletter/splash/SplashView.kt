package com.example.sabnewsletter.splash

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sabnewsletter.repository.AuthenticationRepository

@Composable
fun SplashView(navController: NavController, viewModel:SplashViewModel =viewModel(
    factory = SplashViewModelFactory(authenticationRepository = AuthenticationRepository(LocalContext.current,navController)))) {
    Log.v("composable splash","splash")
    Column {
    Text(text = "LOADING!!!!!!!!!!!")
    //val authenticationRepository = AuthenticationRepository(LocalContext.current,navController)
    //authenticationRepository.checkIsUserLoggedIn()
}
}