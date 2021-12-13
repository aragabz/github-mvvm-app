package com.ragabz.githubapp.base

sealed class NetworkState {
    object LOADED : NetworkState()
    object LOADING : NetworkState()
    data class ERROR(val msg: String): NetworkState()
}
