package com.example.android4_2.data.remote.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.android4_2.data.paging.source.AnimePagingSource
import com.example.android4_2.data.paging.source.MangaPagingSource
import com.example.android4_2.data.remote.apiservices.AnimeApi
import com.example.android4_2.data.remote.models.anime.Data
import javax.inject.Inject

class AnimeRepositories @Inject constructor(
    private val animeApi: AnimeApi
) {
    fun fetchAnime(): LiveData<PagingData<Data>> {

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimePagingSource(animeApi) }
        ).liveData
    }

    fun fetchManga(): LiveData<PagingData<Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),

            pagingSourceFactory = { MangaPagingSource(animeApi) }
        ).liveData
    }
}