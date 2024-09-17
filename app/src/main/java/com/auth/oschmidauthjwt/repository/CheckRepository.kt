package com.auth.oschmidauthjwt.repository

import android.content.Context
import androidx.navigation.NavController
import com.auth.oschmidauthjwt.network.SabencosAuthentication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class CheckRepository(private val context: Context, private val navController: NavController) {
    private val authRepository=AuthenticationRepository(context,navController)
    private val sabencosAuthentication: SabencosAuthentication
        get() {
            return SabencosAuthentication
        }
    private val coroutineScope= CoroutineScope(Dispatchers.Main+ Job())
    suspend fun getToken():Boolean?{
        return withContext(Dispatchers.IO) {
            try {
                val headers = authRepository.getAuthHeaders(true)
                val response=sabencosAuthentication.authenticationApi.testGet(headers = headers).await()
                return@withContext true
            }
            catch(exception:Exception){
                val response =authRepository.checkAuthErrorAndTakeAction(exception)
                if(response){
                    return@withContext getToken()
                }
                return@withContext null
            }

        }
    }
}