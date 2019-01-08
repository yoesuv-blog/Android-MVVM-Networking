package com.yoesuv.mvvmnetworking.menu.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yoesuv.mvvmnetworking.menu.models.ListPlaceResponseModel
import com.yoesuv.mvvmnetworking.networks.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainRepository()

    var listPlace: MutableLiveData<ListPlaceResponseModel> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getListPlace(){
        repository.requestListPlace({
            listPlace.postValue(it)
        },{
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }

}