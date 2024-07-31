package com.example.sabnewsletter.dashboard

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.sabnewsletter.repository.AuthenticationRepository
import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sabnewsletter.repository.CheckRepository
import com.example.sabnewsletter.splash.SplashViewModel
import com.example.sabnewsletter.splash.SplashViewModelFactory

@Composable
fun DashboardView(context: Context, navController: NavController,viewModel: DashboardViewModel = viewModel(
    factory = DashboardViewModelFactory(checkRepository = CheckRepository(LocalContext.current,navController))
)
) {
    //val context= LocalContext.current

    val authenticationRepository=AuthenticationRepository(context,navController)
    Column {
        Text(text = "This is Dashboard")
        Button(onClick = {authenticationRepository.logOutUser() }) {
            Text("Logout")

        }
        Button(onClick ={viewModel.checkToken()} ){

        }
    }


}