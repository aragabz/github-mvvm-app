package com.ragabz.githubapp.data.remote.models


import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class GithubRepoNetworkModel(
    @SerializedName("archived") val archived: Boolean, // true
    @SerializedName("createdAt") val createdAt: String, // 2011-12-29T18:02:34Z
    @SerializedName("description") val description: String, // Simple URL shortener for ActionBarSherlock using node.js and express.
    @SerializedName("forks") val forks: Int, // 1
    @SerializedName("forks_count") val forksCount: Int, // 1
    @SerializedName("full_name") val fullName: String, // JakeWharton/abs.io
    @SerializedName("git_url") val gitUrl: String, // git://github.com/JakeWharton/abs.io.git
    @SerializedName("id") val id: Int, // 3070104
    @SerializedName("language") val language: String, // JavaScript
    @SerializedName("name") val name: String, // abs.io
    @SerializedName("stargazers_count") val stargazersCount: Int, // 9
    @SerializedName("updated_at") val updatedAt: String, // 2021-05-28T07:14:19Z
    @SerializedName("url") val url: String, // https://api.github.com/repos/JakeWharton/abs.io
    @SerializedName("watchers_count") val watchersCount: Int
)