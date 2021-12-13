package com.ragabz.githubapp.data.remote.models


import com.google.gson.annotations.SerializedName

data class Permissions(
    @SerializedName("admin")
    var admin: Boolean,
    @SerializedName("pull")
    var pull: Boolean,
    @SerializedName("push")
    var push: Boolean
)