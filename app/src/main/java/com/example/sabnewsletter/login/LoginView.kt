package com.example.sabnewsletter.login



import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.sabnewsletter.navigation.NavigationConstant

@Composable
fun LoginView(navController: NavController,viewModel:LoginViewModel=LoginViewModel(LocalContext.current)){
    Row(modifier = Modifier.fillMaxSize()
    ){
        val isAuthenticated by viewModel.isAuthenticate.observeAsState(false)

        Button(onClick = { viewModel.getSetCredentials()}) {
            Text(text = "Click to login")     
        }

        if(isAuthenticated){
            navController.navigate(NavigationConstant.DASHOBARD){
                launchSingleTop = true
                popUpTo(0)

            }
        }
    }
    
}