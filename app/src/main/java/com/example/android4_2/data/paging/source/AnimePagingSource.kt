package com.example.android4_2.data.paging.source

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android4_2.data.remote.apiservices.KitsuApi
import com.example.android4_2.models.DataItem
import okio.IOException
import retrofit2.HttpException

class AnimePagingSource(private val animeApi: KitsuApi) :
    PagingSource<Int, DataItem>() {

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        val pageSize = params.loadSize
        val position = params.key ?: 1
        return try {
            val response = animeApi.getAnime(limit = pageSize, offset = position)
            val nextPage =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPage
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}