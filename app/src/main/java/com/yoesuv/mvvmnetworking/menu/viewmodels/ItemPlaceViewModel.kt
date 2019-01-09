package com.yoesuv.mvvmnetworking.menu.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.yoesuv.mvvmnetworking.menu.models.ListPlaceResponseModel

class ItemPlaceViewModel(model: ListPlaceResponseModel.PlaceModel): ViewModel() {

    var title: ObservableField<String> = ObservableField()
    var location: ObservableField<String> = ObservableField()
    var image: ObservableField<String> = ObservableField()

    init {
        title.set(model.name)
        location.set(model.location)
        image.set(model.image)
    }
}