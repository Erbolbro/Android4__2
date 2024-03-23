package com.example.android4_2.data.remote.models.manga

import com.google.gson.annotations.SerializedName

data class Large(@SerializedName("width")
                 val width: String,
                 @SerializedName("height")
                 val height: String)