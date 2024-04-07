package com.example.android4_2.data.remote.apiservices

import com.example.android4_2.models.DataItem
import com.example.android4_2.models.DetailKitsuResponse
import com.example.android4_2.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val END_POINT = "anime/"
private const val END_POINT_MANGA = "manga/"
private const val END_POINT_ANIME_ID = "anime/{id}"
private const val END_POINT_MANGA_ID = "manga/{id}"

interface KitsuApi {
    @GET(END_POINT)
    suspend fun getAnime(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int,
    ): KitsuResponse<DataItem>

    @GET(END_POINT_ANIME_ID)
    suspend fun idAnime(
        @Path("id") id: Int
    ): DetailKitsuResponse

    @GET(END_POINT_MANGA)
    suspend fun getManga(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int
    ): KitsuResponse<DataItem>

    @GET(END_POINT_MANGA_ID)
    suspend fun idManga(
        @Path("id") id: Int
    ): DetailKitsuResponse

}