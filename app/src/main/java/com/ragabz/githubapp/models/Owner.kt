package com.ragabz.githubapp.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Owner(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/66577?v=4
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/users/JakeWharton/events{/privacy}
    @SerializedName("followers_url")
    val followersUrl: String, // https://api.github.com/users/JakeWharton/followers
    @SerializedName("following_url")
    val followingUrl: String, // https://api.github.com/users/JakeWharton/following{/other_user}
    @SerializedName("gists_url")
    val gistsUrl: String, // https://api.github.com/users/JakeWharton/gists{/gist_id}
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/JakeWharton
    @SerializedName("id")
    val id: Int, // 66577
    @SerializedName("login")
    val login: String, // JakeWharton
    @SerializedName("node_id")
    val nodeId: String, // MDQ6VXNlcjY2NTc3
    @SerializedName("organizations_url")
    val organizationsUrl: String, // https://api.github.com/users/JakeWharton/orgs
    @SerializedName("received_events_url")
    val receivedEventsUrl: String, // https://api.github.com/users/JakeWharton/received_events
    @SerializedName("repos_url")
    val reposUrl: String, // https://api.github.com/users/JakeWharton/repos
    @SerializedName("site_admin")
    val siteAdmin: Boolean, // false
    @SerializedName("starred_url")
    val starredUrl: String, // https://api.github.com/users/JakeWharton/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String, // https://api.github.com/users/JakeWharton/subscriptions
    @SerializedName("type")
    val type: String, // User
    @SerializedName("url")
    val url: String // https://api.github.com/users/JakeWharton
) : Parcelable