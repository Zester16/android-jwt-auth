package com.auth.oschmidauthjwt.dashboard

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.auth.oschmidauthjwt.repository.AuthenticationRepository
import androidx.lifecycle.viewmodel.compose.viewModel
import com.auth.oschmidauthjwt.dashboard.DashboardViewModel
import com.auth.oschmidauthjwt.dashboard.DashboardViewModelFactory
import com.auth.oschmidauthjwt.repository.CheckRepository

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