package com.ragabz.githubapp.repositories

import com.ragabz.githubapp.base.Result
import com.ragabz.githubapp.data.local.datasource.GithubRepoLocalDataSource
import com.ragabz.githubapp.data.remote.datasource.GithubRepoRemoteDataSource
import com.ragabz.githubapp.data.toEntity
import com.ragabz.githubapp.data.toModel
import com.ragabz.githubapp.di.ContextProviders
import com.ragabz.githubapp.models.GithubRepo
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import javax.inject.Inject

class GithubRepoRepositoryImpl @Inject constructor(
    private val remoteDataSource: GithubRepoRemoteDataSource,
    private val localDataSource: GithubRepoLocalDataSource,
    private val contextProviders: ContextProviders
) : GithubRepoRepository {
    override suspend fun getRepos(page: Int): Flow<Result<List<GithubRepo>>> {
        return remoteDataSource.getRepos(page = page).flatMapLatest {
            Timber.i("after get repos list: $it")
            when (it) {
                is Result.Error -> flowOf(Result.Error(it.message))
                is Result.Success -> {
                    val list = it.data
                    with(localDataSource) {
                        Timber.i("before insertion: $it")
                        insertAll(*list.toEntity().toTypedArray())
                        coroutineScope {
                            val selectedList = selectRepos().toModel()
                            Timber.i("database : $selectedList")
                            flowOf((Result.Success(selectedList)))
                        }
                    }
                }
            }
        }.flowOn(contextProviders.IO)
    }
}