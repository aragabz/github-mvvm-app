package com.ragabz.githubapp.data.local.datasource

import com.ragabz.githubapp.data.local.entities.GithubRepoEntity

interface GithubRepoLocalDataSource {

    suspend fun insertAll(vararg list:GithubRepoEntity)

    suspend fun selectRepos(): List<GithubRepoEntity>
}