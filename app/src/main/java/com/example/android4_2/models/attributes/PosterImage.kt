package com.example.android4_2.models.attributes

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("small")
    val small: String? = null,
    @SerializedName("original")
    val original:String? = null
)