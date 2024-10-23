package com.direyesm.data.remote.models

import com.google.gson.annotations.SerializedName

data class BreedsResponse(
    @SerializedName("message")
    val message: Map<String, List<String>>,
    @SerializedName("status")
    val status: String
)
