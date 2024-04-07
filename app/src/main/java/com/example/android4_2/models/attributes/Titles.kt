package com.example.android4_2.models.attributes

import com.google.gson.annotations.SerializedName

data class Titles(
    @SerializedName("en")
    val en: String? = null,
    @SerializedName("ja_jp")
    val jaJp: String? = null,
    @SerializedName("en_jp")
    val enJp: String? = null
)