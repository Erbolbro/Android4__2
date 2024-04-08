package com.example.android4_2.data.remote.models.attributes

import com.example.android4_2.data.remote.models.anime.RatingFrequencies
import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("synopsis")
    val detail: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("titles")
    val title: Title,
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("ratingFrequencies")
    val ratingFrequencies: RatingFrequencies,
    @SerializedName("coverImage")
    val coverImage: CoverImage? = null,
    @SerializedName("endDate")
    val endDate:String,
    @SerializedName("ageRating")
    val ageRating:String
)

 data class Title(
     @SerializedName("en")
     val en :String? = null,
     @SerializedName("enJp")
     val enJp:String? = null,
     @SerializedName("ja_jp")
     val ja_jp:String? = null
 )
