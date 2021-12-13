package com.ragabz.githubapp.data.local.datasource

import com.ragabz.githubapp.data.local.dao.GithubRepoDao
import com.ragabz.githubapp.data.local.entities.GithubRepoEntity
import javax.inject.Inject

class GithubRepoLocalDataSourceImpl
@Inject constructor(
    private val githubRepoDao: GithubRepoDao
) : GithubRepoLocalDataSource {
    override suspend fun insertAll(vararg list:GithubRepoEntity) {
        githubRepoDao.insertAll(*list)
    }

    override suspend fun selectRepos(): List<GithubRepoEntity> {
        return githubRepoDao.getAllRepos()
    }
}