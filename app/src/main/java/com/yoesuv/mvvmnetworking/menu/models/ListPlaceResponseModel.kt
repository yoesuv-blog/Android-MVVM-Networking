package com.yoesuv.mvvmnetworking.menu.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListPlaceResponseModel(
    @SerializedName("status_code") @Expose var statusCode: Int,
    @SerializedName("data") @Expose var data: MutableList<PlaceModel>
) {
    data class PlaceModel(
        @SerializedName("name") @Expose  var name: String,
        @SerializedName("location") @Expose var location: String,
        @SerializedName("image") @Expose var image: String
    )
}