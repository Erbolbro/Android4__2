package com.example.android4_2.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android4_2.data.paging.source.AnimePagingSource
import com.example.android4_2.data.paging.source.MangaPagingSource
import com.example.android4_2.data.remote.apiservices.KitsuApi
import com.example.android4_2.data.remote.models.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class KitsuRepositories @Inject constructor(
    private val kitsuapi: KitsuApi,
) {
    fun fetchAnime(): Flow<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimePagingSource(kitsuapi) }
        ).flow
    }

    fun fetchManga(): Flow<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { MangaPagingSource(kitsuapi) }
        ).flow
    }

    suspend fun getAnimeId(id: Int) = runCatching {
        withContext(Dispatchers.IO) {
            kitsuapi.idAnime(id).data
        }
    }

}