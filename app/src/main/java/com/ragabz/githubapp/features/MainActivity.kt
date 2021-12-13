package com.ragabz.githubapp.features

import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ragabz.githubapp.R
import com.ragabz.githubapp.base.ViewBindingActivity
import com.ragabz.githubapp.databinding.ActivityMainBinding
import com.ragabz.githubapp.extensions.createSnackBar
import com.ragabz.githubapp.extensions.visible
import com.ragabz.githubapp.features.viewmodels.MainViewModel
import com.ragabz.githubapp.utils.EndlessRecyclerViewScrollListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import syntex_error.simec.technical_test.verseApp.utils.ConnectionLiveData
import com.ragabz.githubapp.utils.Utils

@AndroidEntryPoint
class MainActivity : ViewBindingActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    lateinit var connectionLiveData: ConnectionLiveData
    var isInternetGone = false
    private val viewModel: MainViewModel by viewModels()
    private val adapter: GithubRepoAdapter by lazy {
        GithubRepoAdapter()
    }

    override fun onInitBinding() {
        connectionLiveData = ConnectionLiveData(this)
        observeNetworkConnection()
        viewModel.getGithubRepos(Utils.isOnline(this))
        initRecyclerView()
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.reposList.collectLatest { adapter.submitList(it) }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.loading.collectLatest {
                    binding.progressBar.visible = it
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.noMoreData.collectLatest {
                    if (it.trim().isNotEmpty()) {
                        binding.root.createSnackBar(it, Snackbar.LENGTH_LONG).show()
                    }
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
                if (isInternetGone) return
                viewModel.getGithubRepos(Utils.isOnline(this@MainActivity))
            }
        }
        binding.recyclerViewRepos.addOnScrollListener(
            scrollListener
        )
    }

    private fun observeNetworkConnection() {
        //check for internet
        connectionLiveData.observe(this) { isNetworkAvailable ->
            if (isNetworkAvailable && isInternetGone == true) {
                binding.root.createSnackBar(
                    getString(R.string.internet_connection_state_connected),
                    Snackbar.LENGTH_LONG
                ).show()
                isInternetGone = false
            } else if (isNetworkAvailable == false) {
                binding.root.createSnackBar(
                    getString(R.string.internet_connection_state_not_connected),
                    Snackbar.LENGTH_LONG
                ).show()
                isInternetGone = true
            }
        }
    }
}