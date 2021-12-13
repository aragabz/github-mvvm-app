package com.ragabz.githubapp.data.repositories

import com.ragabz.githubapp.base.Result
import com.ragabz.githubapp.data.local.datasource.GithubRepoLocalDataSource
import com.ragabz.githubapp.data.remote.datasource.GithubRepoRemoteDataSource
import com.ragabz.githubapp.data.toEntity
import com.ragabz.githubapp.data.toModel
import com.ragabz.githubapp.data.toModelList
import com.ragabz.githubapp.di.ContextProviders
import com.ragabz.githubapp.domain.repositories.GithubRepoRepository
import com.ragabz.githubapp.domain.models.GithubRepo
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

class GithubRepoRepositoryImpl @Inject constructor(
    private val remoteDataSource: GithubRepoRemoteDataSource,
    private val localDataSource: GithubRepoLocalDataSource,
    private val contextProviders: ContextProviders
) : GithubRepoRepository {
    override suspend fun getRepos(isConnected: Boolean, page: Int): Flow<Result<List<GithubRepo>>> {
        return when (isConnected) {
            true -> remoteDataSource.getRepos(page = page).flatMapLatest {
                Timber.i("after get repos list: $it")
                when (it) {
                    is Result.Error -> flowOf(Result.Error(it.message))
                    is Result.Success -> {
                        val list = it.data
                        with(localDataSource) {
                            Timber.i("before insertion: $it")
                            insertAll(*list.toEntity().toTypedArray())
                            flowOf((Result.Success(list.toModelList())))
                        }
                    }
                }
            }.flowOn(contextProviders.IO)
            /**
             * if there is no connection
             */
            false -> flowOf(
                Result.Success(
                    localDataSource.selectRepos().toModel()
                )
            ).flowOn(contextProviders.IO)
        }

    }
}