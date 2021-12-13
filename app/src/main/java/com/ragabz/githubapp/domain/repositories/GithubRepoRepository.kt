package com.ragabz.githubapp.domain.repositories

import com.ragabz.githubapp.base.Result
import com.ragabz.githubapp.domain.models.GithubRepo
import kotlinx.coroutines.flow.Flow

interface GithubRepoRepository {
    suspend fun getRepos(isConnected: Boolean, page: Int): Flow<Result<List<GithubRepo>>>
}