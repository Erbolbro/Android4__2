package com.example.android4_2.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4_2.data.repositories.KitsuRepositories
import com.example.android4_2.models.DataItem
import com.example.android4_2.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val kitsuRepositories: KitsuRepositories,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _detailState = MutableLiveData<UiState<DataItem>>()
    val detailState: LiveData<UiState<DataItem>> = _detailState

    private val id = savedStateHandle.get<String>(ID_KAY)

    fun setId(id: String) {
        savedStateHandle[ID_KAY] = id
    }

    init {
        viewModelScope.launch {
            id?.let {
                kitsuRepositories.getAnimeId(id.toInt()).fold(
                    onSuccess = {
                        _detailState.value = UiState.Success(it)
                    },
                    onFailure = {
                        _detailState.value = UiState.Error(it, it.message ?: "unknown error!")
                    }
                )
            }
        }
        viewModelScope.launch {
            id?.let {
                kitsuRepositories.getMangaId(id.toInt()).fold(
                    onSuccess = {
                        _detailState.value = UiState.Success(it)
                    },
                    onFailure = {
                        _detailState.value = UiState.Error(it, it.message ?: "unknown error!")
                    }
                )
            }
        }
    }

    companion object {
        private const val ID_KAY = "id"
    }
}