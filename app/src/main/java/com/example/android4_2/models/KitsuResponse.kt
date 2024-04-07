package com.example.android4_2.models

import com.google.gson.annotations.SerializedName

data class KitsuResponse<T>(
    @SerializedName("links")
    val links: Links,
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("meta")
    val meta :Meta
)