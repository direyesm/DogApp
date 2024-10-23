package com.direyesm.data.remote.models

import com.google.gson.annotations.SerializedName


data class BreedsImagesResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)