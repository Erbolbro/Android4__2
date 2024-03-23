package com.example.android4_2.ui.fragments.manga

import androidx.lifecycle.ViewModel
import com.example.android4_2.data.remote.repositories.AnimeRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: AnimeRepositories
) : ViewModel() {

    fun getManga() = repositories.fetchManga()
}