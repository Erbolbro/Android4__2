package com.example.android4_2.data.remote.models

import com.example.android4_2.data.remote.models.attributes.Attributes
import com.google.gson.annotations.SerializedName
data class DataItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("type")
    val type: String,
    @SerializedName("self")
    val self: LinksSelf
)

data class LinksSelf(
    @SerializedName("self")
    val self: String
)
