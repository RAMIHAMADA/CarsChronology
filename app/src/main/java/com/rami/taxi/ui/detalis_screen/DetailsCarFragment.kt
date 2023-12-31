package com.rami.taxi.ui.detalis_screen

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.rami.taxi.R
import com.rami.taxi.adapters.PostAdapter
import com.rami.taxi.adapters.ViewPagerAdapter
import com.rami.taxi.databinding.FragmentDetailsCarBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsCarFragment : Fragment(R.layout.fragment_details_car) {
    private val binding: FragmentDetailsCarBinding by viewBinding()
    private val viewModel: DetailsCarViewModel by viewModels()
    private val args by navArgs<DetailsCarFragmentArgs>()

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var postAdapter: PostAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.updateState(args.carId)
        initObserver()
        initAdapters()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.screenState.collect { state ->
                renderState(state)
            }
        }
    }

    private fun renderState(state: DetailsCarState) {
        loaderIsEnable(state)
        setDataForAdapters(state)
        setUserAvatar(state)
        if (state.isLoaded) {
            binding.dotsIndicator.attachTo(binding.viewPagerContainer)
            binding.headTitle.text = state.someCar.name
            binding.userName.text = state.listPosts.firstOrNull()?.author?.username ?: ""
        }
    }

    private fun loaderIsEnable(state: DetailsCarState) {
        binding.groupDontLoad.isVisible = state.isLoaded
        binding.loader.isVisible = !state.isLoaded
    }

    private fun setDataForAdapters(state: DetailsCarState) {
        if (!state.isLoaded) return
        viewPagerAdapter.setData(state.someCar.listUrl)
        postAdapter.setData(state.listPosts)
    }

    private fun setUserAvatar(state: DetailsCarState) {
        if (!state.isLoaded) return
        val avatar = state.listPosts.firstOrNull()?.author?.avatar?.url
        if (avatar != null) {
            binding.userAvatar.loadImageFromUrl(avatar)
        } else {
            binding.userAvatar.setImageResource(R.mipmap.ic_launcher_round)
        }
    }

    private fun initAdapters() {
        viewPagerAdapter = ViewPagerAdapter()
        binding.viewPagerContainer.adapter = viewPagerAdapter

        postAdapter = PostAdapter()
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = postAdapter
    }

    private fun ImageView.loadImageFromUrl(url: String) {
        val glide = Glide.with(context)
            .load(url)
        glide.into(this)
    }
}
