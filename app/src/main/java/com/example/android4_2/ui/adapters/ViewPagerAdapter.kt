package com.example.android4_2.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android4_2.ui.fragments.anime.AnimeFragment
import com.example.android4_2.ui.fragments.manga.MangaFragment
class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return if (position == 1) MangaFragment() else AnimeFragment()
    }
}