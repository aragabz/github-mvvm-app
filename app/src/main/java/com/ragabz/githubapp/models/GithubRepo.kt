package com.ragabz.githubapp.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.RawValue

@Entity
@Parcelize
data class GithubRepo(
    @SerializedName("allow_forking")
    val allowForking: Boolean, // true
    @SerializedName("archive_url")
    val archiveUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/{archive_format}{/ref}
    @SerializedName("archived")
    @ColumnInfo
    val archived: Boolean, // true
    @SerializedName("assignees_url")
    val assigneesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/assignees{/user}
    @SerializedName("blobs_url")
    val blobsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/git/blobs{/sha}
    @SerializedName("branches_url")
    val branchesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/branches{/branch}
    @SerializedName("clone_url")
    val cloneUrl: String, // https://github.com/JakeWharton/abs.io.git
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/collaborators{/collaborator}
    @SerializedName("comments_url")
    val commentsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/comments{/number}
    @SerializedName("commits_url")
    val commitsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/commits{/sha}
    @SerializedName("compare_url")
    val compareUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/compare/{base}...{head}
    @SerializedName("contents_url")
    val contentsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/contents/{+path}
    @SerializedName("contributors_url")
    val contributorsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/contributors
    @SerializedName("created_at")
    @ColumnInfo
    val createdAt: String, // 2011-12-29T18:02:34Z
    @SerializedName("default_branch")
    val defaultBranch: String, // master
    @SerializedName("deployments_url")
    val deploymentsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/deployments
    @SerializedName("description")
    @ColumnInfo
    val description: String, // Simple URL shortener for ActionBarSherlock using node.js and express.
    @SerializedName("disabled")
    val disabled: Boolean, // false
    @SerializedName("downloads_url")
    val downloadsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/downloads
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/events
    @SerializedName("fork")
    val fork: Boolean, // false
    @SerializedName("forks")
    @ColumnInfo
    val forks: Int, // 1
    @SerializedName("forks_count")
    @ColumnInfo
    val forksCount: Int, // 1
    @SerializedName("forks_url")
    val forksUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/forks
    @SerializedName("full_name")
    @ColumnInfo
    val fullName: String, // JakeWharton/abs.io
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/git/commits{/sha}
    @SerializedName("git_refs_url")
    val gitRefsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/git/refs{/sha}
    @SerializedName("git_tags_url")
    val gitTagsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/git/tags{/sha}
    @SerializedName("git_url")
    @ColumnInfo
    val gitUrl: String, // git://github.com/JakeWharton/abs.io.git
    @SerializedName("has_downloads")
    val hasDownloads: Boolean, // true
    @SerializedName("has_issues")
    val hasIssues: Boolean, // true
    @SerializedName("has_pages")
    val hasPages: Boolean, // false
    @SerializedName("has_projects")
    val hasProjects: Boolean, // true
    @SerializedName("has_wiki")
    val hasWiki: Boolean, // false
    @SerializedName("homepage")
    val homepage: String, // http://abs.io
    @SerializedName("hooks_url")
    val hooksUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/hooks
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/JakeWharton/abs.io
    @PrimaryKey
    @SerializedName("id")
    val id: Int, // 3070104
    @SerializedName("is_template")
    val isTemplate: Boolean, // false
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/issues/comments{/number}
    @SerializedName("issue_events_url")
    val issueEventsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/issues/events{/number}
    @SerializedName("issues_url")
    val issuesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/issues{/number}
    @SerializedName("keys_url")
    val keysUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/keys{/key_id}
    @SerializedName("labels_url")
    val labelsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/labels{/name}
    @SerializedName("language")
    @ColumnInfo
    val language: String, // JavaScript
    @SerializedName("languages_url")
    val languagesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/languages
    @SerializedName("license")
    val license: License, // null
    @SerializedName("merges_url")
    val mergesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/merges
    @SerializedName("milestones_url")
    val milestonesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/milestones{/number}
    @SerializedName("mirror_url")
    val mirrorUrl: @RawValue Any, // null
    @SerializedName("name")
    @ColumnInfo
    val name: String, // abs.io
    @SerializedName("node_id")
    val nodeId: String, // MDEwOlJlcG9zaXRvcnkzMDcwMTA0
    @SerializedName("notifications_url")
    val notificationsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/notifications{?since,all,participating}
    @SerializedName("open_issues")
    val openIssues: Int, // 0
    @SerializedName("open_issues_count")
    val openIssuesCount: Int, // 0
    @SerializedName("owner")
    @ColumnInfo
    val owner: Owner,
    @SerializedName("private")
    val isPrivate: Boolean, // false
    @SerializedName("pulls_url")
    val pullsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/pulls{/number}
    @SerializedName("pushed_at")
    val pushedAt: String, // 2011-12-29T18:02:44Z
    @SerializedName("releases_url")
    val releasesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/releases{/id}
    @SerializedName("size")
    val size: Int, // 108
    @SerializedName("ssh_url")
    val sshUrl: String, // git@github.com:JakeWharton/abs.io.git
    @SerializedName("stargazers_count")
    @ColumnInfo
    val stargazersCount: Int, // 9
    @SerializedName("stargazers_url")
    val stargazersUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/stargazers
    @SerializedName("statuses_url")
    val statusesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/statuses/{sha}
    @SerializedName("subscribers_url")
    val subscribersUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/subscribers
    @SerializedName("subscription_url")
    val subscriptionUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/subscription
    @SerializedName("svn_url")
    val svnUrl: String, // https://github.com/JakeWharton/abs.io
    @SerializedName("tags_url")
    val tagsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/tags
    @SerializedName("teams_url")
    val teamsUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/teams
    @SerializedName("topics")
    val topics: List<String>,
    @SerializedName("trees_url")
    val treesUrl: String, // https://api.github.com/repos/JakeWharton/abs.io/git/trees{/sha}
    @SerializedName("updated_at")
    @ColumnInfo
    val updatedAt: String, // 2021-05-28T07:14:19Z
    @SerializedName("url")
    @ColumnInfo
    val url: String, // https://api.github.com/repos/JakeWharton/abs.io
    @SerializedName("visibility")
    val visibility: String, // public
    @SerializedName("watchers")
    val watchers: Int, // 9
    @SerializedName("watchers_count")
    @ColumnInfo
    val watchersCount: Int // 9
) : Parcelable