package com.ragabz.githubapp.features.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragabz.githubapp.base.onError
import com.ragabz.githubapp.base.onSuccess
import com.ragabz.githubapp.data.remote.datasource.GithubRepoRemoteDataSource
import com.ragabz.githubapp.domain.models.GithubRepo
import com.ragabz.githubapp.domain.repositories.GithubRepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val remoteDataSource: GithubRepoRemoteDataSource,
    private val githubRepoRepository: GithubRepoRepository
) : ViewModel() {

    val initialPage = 1
    var page = initialPage

    private val _repoList = MutableStateFlow<List<RepoItemViewModel>>(mutableListOf())
    val reposList: StateFlow<List<RepoItemViewModel>> = _repoList

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String>("")
    val error: StateFlow<String> = _error

    private val _noMoreData = MutableStateFlow<String>("")
    val noMoreData: StateFlow<String> = _noMoreData

    fun getGithubRepos(isConnected: Boolean) {
        showLoading()
        viewModelScope.launch {
            githubRepoRepository.getRepos(isConnected, page).collect {
                it.onSuccess {
                    handleSuccess(isConnected, it)
                }.onError {
                    handleError(it ?: "error happened")
                }
            }
        }
    }

    private fun hideLoading() {
        _loading.value = false
    }

    private fun showLoading() {
        _loading.value = true
    }

    private fun handleSuccess(isConnected: Boolean, list: List<GithubRepo>) {
        if (list.isEmpty()) {
            _noMoreData.value = "No More Data"
            hideLoading()
            return
        }
        when (isConnected) {
            true -> {
                val itemsList = mutableListOf<RepoItemViewModel>().apply {
                    addAll(_repoList.value)
                    addAll(list.map { repo -> RepoItemViewModel(repo) })
                }
                _repoList.value = itemsList
                page += 1
            }
            false -> {
                val list = mutableListOf<RepoItemViewModel>().apply {
                    addAll(list.map { repo -> RepoItemViewModel(repo) })
                }
                _repoList.value = list
            }
        }
        hideLoading()
    }

    private fun handleError(message: String) {
        Timber.e(message)
        _error.value = message
        hideLoading()
    }


}