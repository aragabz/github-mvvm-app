package com.ragabz.githubapp.data.remote.datasource

import com.ragabz.githubapp.base.Result
import com.ragabz.githubapp.data.remote.api.GithubRepoApi
import com.ragabz.githubapp.data.remote.models.GithubRepoNetworkModel
import com.ragabz.githubapp.extensions.toFlow
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

class GithubRepoRemoteDataSourceImpl
@Inject constructor(
    private val githubRepoApi: GithubRepoApi
) : GithubRepoRemoteDataSource {
    override suspend fun getRepos(page: Int): Flow<Result<List<GithubRepoNetworkModel>>> {
        val response = githubRepoApi.getUserRepos(page = page)
        val list = response.body() as List<GithubRepoNetworkModel>
        Timber.i("lis before to flow() --> $list")
        return response.toFlow()
    }
}


