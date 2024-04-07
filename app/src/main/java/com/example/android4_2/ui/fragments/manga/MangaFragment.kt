package com.example.android4_2.ui.fragments.manga

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4_2.R
import com.example.android4_2.databinding.FragmentMangaBinding
import com.example.android4_2.ui.adapters.KitsuAdapter
import com.example.android4_2.ui.fragments.ViewPagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.fragment_manga) {
    private val binding by viewBinding(FragmentMangaBinding::bind)
    private val viewModel by viewModels<MangaViewModel>()
    private val mangaAdapter = KitsuAdapter(::onClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
        viewLifecycleOwner.lifecycleScope.launch {
            delay(2000)
            if (binding.progressBar.isVisible) {
                binding.progressBar.isVisible = false
            }
        }
        handlePagingState()
    }

    private fun initialize() = with(binding) {
        rvManga.adapter = mangaAdapter
    }

    private fun setupObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.mangaState.collectLatest {
                mangaAdapter.submitData(it)
            }
        }
    }

    private fun handlePagingState() = with(binding) {//        handlePagingState()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mangaAdapter.loadStateFlow.collect {
                    progressBar.isVisible = it.source.refresh is LoadState.Loading
                    appendProgress.isVisible = it.source.append is LoadState.Loading
                    prependProgress.isVisible = it.source.prepend is LoadState.Loading
                }
            }
        }
    }

    private fun onClick(id: String) {
        findNavController().navigate(
            ViewPagerFragmentDirections.actionViewPagerFragmentToDetailFragment(
                id
            )
        )
    }
}