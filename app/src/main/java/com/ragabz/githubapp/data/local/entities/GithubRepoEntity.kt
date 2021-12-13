package com.ragabz.githubapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class GithubRepoEntity(
    @ColumnInfo
    @SerializedName("archived") val archived: Boolean, // true
    @ColumnInfo
    @SerializedName("createdAt") val createdAt: String, // 2011-12-29T18:02:34Z
    @ColumnInfo
    @SerializedName("description") val description: String, // Simple URL shortener for ActionBarSherlock using node.js and express.
    @ColumnInfo
    @SerializedName("forks") val forks: Int, // 1
    @ColumnInfo
    @SerializedName("forks_count") val forksCount: Int, // 1
    @ColumnInfo
    @SerializedName("full_name") val fullName: String, // JakeWharton/abs.io
    @ColumnInfo
    @SerializedName("git_url") val gitUrl: String, // git://github.com/JakeWharton/abs.io.git
    @PrimaryKey
    @SerializedName("id") val id: Int, // 3070104
    @ColumnInfo
    @SerializedName("language") val language: String, // JavaScript
    @ColumnInfo
    @SerializedName("name") val name: String, // abs.io
    @ColumnInfo
    @SerializedName("stargazers_count") val stargazersCount: Int, // 9
    @ColumnInfo
    @SerializedName("updated_at") val updatedAt: String, // 2021-05-28T07:14:19Z
    @ColumnInfo
    @SerializedName("url") val url: String, // https://api.github.com/repos/JakeWharton/abs.io
    @ColumnInfo
    @SerializedName("watchers_count") val watchersCount: Int
)
