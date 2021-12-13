package com.ragabz.githubapp.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ragabz.githubapp.BuildConfig
import com.ragabz.githubapp.R
import com.ragabz.githubapp.base.DataBindingActivity
import com.ragabz.githubapp.base.ViewBindingActivity
import com.ragabz.githubapp.databinding.ActivityMainBinding
import com.ragabz.githubapp.utils.EndlessRecyclerViewScrollListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ViewBindingActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    private val viewModel: MainViewModel by viewModels()
    private val adapter: GithubRepoAdapter by lazy {
        GithubRepoAdapter()
    }

    override fun onInitBinding() {
        viewModel.getGithubRepos()
        initRecyclerView()
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.reposList.observe(
                    this@MainActivity
                ) {
                    adapter.submitList(it)
                }
            }
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewRepos.adapter = adapter
        val layoutManager =
            binding.recyclerViewRepos.layoutManager as LinearLayoutManager
        val scrollListener = object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                viewModel.getGithubRepos()
            }
        }
        binding.recyclerViewRepos.addOnScrollListener(
            scrollListener
        )
    }
}