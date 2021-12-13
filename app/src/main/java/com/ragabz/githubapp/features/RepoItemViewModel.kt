package com.ragabz.githubapp.features

import androidx.lifecycle.ViewModel
import com.ragabz.githubapp.data.remote.models.GithubRepoNetworkModel
import com.ragabz.githubapp.models.GithubRepo

class RepoItemViewModel(private val githubRepo: GithubRepo) : ViewModel() {

    val id: Int
        get() = githubRepo.id
    val name: String
        get() = githubRepo.name


    val fullName: String
        get() = githubRepo.fullName


    val description: String
        get() = githubRepo.description
}