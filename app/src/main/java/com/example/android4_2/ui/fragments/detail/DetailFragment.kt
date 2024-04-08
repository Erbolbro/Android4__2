package com.example.android4_2.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.android4_2.R
import com.example.android4_2.databinding.FragmentDetailBinding
import com.example.android4_2.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val args by navArgs<DetailFragmentArgs>()
    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.id?.let {
            viewModel.setId(it)
        }
        subscribeToDetail()
        goBack()
    }

    private fun subscribeToDetail() {
        viewModel.detailState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UiState.Error -> Log.e("detail", uiState.message, uiState.throwable)
                UiState.Loading -> view?.let {
                }

                is UiState.Success -> {
                    uiState.data?.let {
                        binding.detaiText.text = it.attributes.description
                        binding.tvDay.text = it.attributes.endDate
                        binding.tvName.text = it.attributes.title.en
                        binding.rating.text = it.attributes.ageRating
                        it.attributes.coverImage?.large?.let { coverImage ->
                            Glide.with(binding.ivFon).load(coverImage).into(binding.ivFon)
                        }
                        Glide.with(binding.ivPoster).load(it.attributes.posterImage.original)
                            .into(binding.ivPoster)
                    }
                }
            }
        }
    }


    private fun goBack() {
        binding.tvBack.setOnClickListener {
            findNavController().navigateUp()

        }
    }
}