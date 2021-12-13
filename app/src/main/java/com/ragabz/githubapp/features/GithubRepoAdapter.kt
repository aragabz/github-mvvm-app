package com.ragabz.githubapp.features

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.ragabz.githubapp.base.ViewBindingHolder
import com.ragabz.githubapp.databinding.ItemRepoBinding

class GithubRepoAdapter : ListAdapter<RepoItemViewModel, RepoViewHolder>(
    RepoDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        with(getItem(position)) {
            (holder.binding as ItemRepoBinding).apply {
                val item = getItem(position)
                textViewId.text = "#${item.id}"
                textViewName.text = item.name
                textViewFullName.text = item.fullName
                textViewDescription.text = item.description
            }
        }
    }

    /**
     * repo diff util callback that used in list adapter
     */
    internal class RepoDiffCallback : DiffUtil.ItemCallback<RepoItemViewModel>() {
        override fun areItemsTheSame(
            oldItem: RepoItemViewModel,
            newItem: RepoItemViewModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RepoItemViewModel,
            newItem: RepoItemViewModel
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}


class RepoViewHolder(
    binding: ViewBinding
) : ViewBindingHolder(binding)
