package com.ragabz.githubapp.repositories

import com.ragabz.githubapp.base.Result
import com.ragabz.githubapp.models.GithubRepo
import kotlinx.coroutines.flow.Flow

interface GithubRepoRepository {
    suspend fun getRepos(page: Int): Flow<Result<List<GithubRepo>>>
}