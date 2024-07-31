package com.auth.oschmidauthjwt.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.auth.oschmidauthjwt.repository.AuthenticationRepository
import com.auth.oschmidauthjwt.repository.CheckRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class DashboardViewModel(private val checkRepository: CheckRepository):ViewModel() {

    private val job = Job()
    private val coroutineJob = CoroutineScope(Dispatchers.Main+job)
    override fun onCleared() {
        coroutineJob.cancel()
        super.onCleared()
    }



    fun checkToken(){
        coroutineJob.launch {
            checkRepository.getToken()
        }

    }


}
class DashboardViewModelFactory(private val checkRepository: CheckRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T = DashboardViewModel(checkRepository) as T
}