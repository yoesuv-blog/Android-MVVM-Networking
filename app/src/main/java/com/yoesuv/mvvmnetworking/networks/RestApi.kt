package com.yoesuv.mvvmnetworking.networks

import com.yoesuv.mvvmnetworking.menu.models.ListPlaceResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {
    @GET("Sample.json")
    fun getListPlace(): Observable<ListPlaceResponseModel>
}