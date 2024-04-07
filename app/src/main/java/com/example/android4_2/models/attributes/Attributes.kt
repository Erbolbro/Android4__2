package com.example.android4_2.models.attributes

import com.example.android4_2.models.RatingFrequencies
import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("synopsis")
    val detail: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("titles")
    val title: Titles,
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("ratingFrequencies")
    val ratingFrequencies: RatingFrequencies,
    @SerializedName("coverImage")
    val coverImage:CoverImage? = null,
    @SerializedName("endDate")
    val endDate:String,
    @SerializedName("ageRating")
    val ageRating:String

)