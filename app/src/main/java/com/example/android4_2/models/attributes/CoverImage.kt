package com.example.android4_2.models.attributes

import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("tiny")
    val tiny: String,
    @SerializedName("small")
    val small:String,
    @SerializedName("large")
    val large:String? = null,
    @SerializedName("original")
    val original:String
)