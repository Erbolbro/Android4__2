package com.example.android4_2.data.remote.models

import com.google.gson.annotations.SerializedName

data class DetailKitsuResponse(
    @SerializedName("data")
    val data: DataItem
)