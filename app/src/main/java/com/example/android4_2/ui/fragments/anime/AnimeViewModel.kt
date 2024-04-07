package com.example.android4_2.ui.fragments.anime

import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.android4_2.data.repositories.KitsuRepositories
import com.example.android4_2.models.DataItem
import com.example.android4_2.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: KitsuRepositories
) : ViewModel() {
  private val _animeState = MutableStateFlow(PagingData.empty<DataItem>())
    val animeState = _animeState.asStateFlow()

    init {
        viewModelScope.launch {
            repositories.fetchAnime().cachedIn(viewModelScope).collectLatest {
                _animeState.value = it
            }
        }
    }
}