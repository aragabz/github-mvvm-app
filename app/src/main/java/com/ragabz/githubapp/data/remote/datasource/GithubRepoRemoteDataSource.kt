package com.ragabz.githubapp.data.remote.datasource

import com.ragabz.githubapp.base.Result
import com.ragabz.githubapp.data.remote.models.GithubRepoNetworkModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface GithubRepoRemoteDataSource {
    suspend fun getRepos(page: Int): Flow<Result<List<GithubRepoNetworkModel>>>
}