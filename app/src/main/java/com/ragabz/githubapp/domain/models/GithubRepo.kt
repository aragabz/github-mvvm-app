package com.ragabz.githubapp.domain.models

data class GithubRepo(
    val id: Int,
    val archived: Boolean,
    val createdAt: String,
    val description: String,
    val forks: Int,
    val forksCount: Int,
    val fullName: String,
    val gitUrl: String,
    val language: String,
    val name: String,
    val stargazersCount: Int,
    val updatedAt: String,
    val url: String,
    val watchersCount: Int
)
