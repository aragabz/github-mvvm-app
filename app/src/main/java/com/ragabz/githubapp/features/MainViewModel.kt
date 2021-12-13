package com.ragabz.githubapp.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragabz.githubapp.base.onError
import com.ragabz.githubapp.base.onSuccess
import com.ragabz.githubapp.data.remote.datasource.GithubRepoRemoteDataSource
import com.ragabz.githubapp.data.remote.models.GithubRepoNetworkModel
import com.ragabz.githubapp.data.toEntity
import com.ragabz.githubapp.repositories.GithubRepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private val _reposLiveData = MutableLiveData<List<RepoItemViewModel>>()
    val reposList: LiveData<List<RepoItemViewModel>> = _reposLiveData


    fun getGithubRepos() {
        viewModelScope.launch {
            githubRepoRepository.getRepos(page).collect {
                it.onSuccess {
                    val itemsList = it.map { repo -> RepoItemViewModel(repo) }
                    _reposLiveData.postValue(itemsList)
                    page += 1
                }.onError {
                    Timber.e(it ?: "error ")
                }
            }
        }
    }


}