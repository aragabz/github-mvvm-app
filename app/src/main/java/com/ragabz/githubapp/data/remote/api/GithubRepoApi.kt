package com.ragabz.githubapp.data.remote.api

import com.ragabz.githubapp.data.local.entities.GithubRepoEntity
import com.ragabz.githubapp.data.remote.models.GithubRepoNetworkModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val USER_NAME = "userName"
const val PAGE = "page"
const val PER_PAGE = "per_page"
const val DEFAULT_ITEM_COUNT = 15

const val USER_JK = "JakeWharton" // to be used to get repos for jake wharton

interface GithubRepoApi {

    @GET("/users/{$USER_NAME}/repos")
    suspend fun getUserRepos(
        @Path(USER_NAME) user: String = USER_JK,
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) perPage: Int = DEFAULT_ITEM_COUNT
    ): Response<List<GithubRepoNetworkModel>>
}