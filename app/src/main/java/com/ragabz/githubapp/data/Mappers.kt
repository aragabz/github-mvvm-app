package com.ragabz.githubapp.data

import com.ragabz.githubapp.data.local.entities.GithubRepoEntity
import com.ragabz.githubapp.data.remote.models.GithubRepoNetworkModel
import com.ragabz.githubapp.models.GithubRepo
import timber.log.Timber

fun GithubRepoEntity.toModel(): GithubRepo = GithubRepo(
    id = this.id,
    archived = this.archived,
    createdAt = this.createdAt,
    description = this.description,
    forks = this.forks,
    forksCount = this.forksCount,
    fullName = this.fullName,
    gitUrl = this.gitUrl,
    language = this.language ?: "",
    name = this.name,
    stargazersCount = this.stargazersCount,
    updatedAt = this.updatedAt,
    url = this.url,
    watchersCount = this.watchersCount
)

fun GithubRepoNetworkModel.toEntity(): GithubRepoEntity {
    Timber.i("convert network to entity: ${this}")
    return GithubRepoEntity(
        id = id,
        archived = archived,
        createdAt = createdAt ?: "",
        description = description ?: "",
        forks = forks,
        forksCount = forksCount,
        fullName = fullName ?: "",
        gitUrl = gitUrl ?: "",
        language = language ?: "",
        name = name ?: "",
        stargazersCount = stargazersCount,
        updatedAt = updatedAt ?: "",
        url = url ?: "",
        watchersCount = watchersCount
    )
}


fun List<GithubRepoNetworkModel>.toEntity(): List<GithubRepoEntity> {
    Timber.i("try to convert listof network to lift of entity")
    return this.map { it.toEntity() }
}

fun List<GithubRepoEntity>.toModel() = this.map { it.toModel() }