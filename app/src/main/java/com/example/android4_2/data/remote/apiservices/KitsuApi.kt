package com.example.android4_2.data.remote.apiservices

import com.example.android4_2.data.remote.models.DataItem
import com.example.android4_2.data.remote.models.DetailKitsuResponse
import com.example.android4_2.data.remote.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val END_POINT_ANIME = "anime/"
private const val END_POINT_MANGA = "manga/"
private const val END_POINT_KITSU_ID = "anime/{id}"

interface KitsuApi {
    @GET(END_POINT_ANIME)
    suspend fun getAnime(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int,
    ): KitsuResponse<DataItem>

    @GET(END_POINT_KITSU_ID)
    suspend fun idAnime(
        @Path("id") id: Int
    ): DetailKitsuResponse

    @GET(END_POINT_MANGA)
    suspend fun getManga(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int
    ): KitsuResponse<DataItem>

}