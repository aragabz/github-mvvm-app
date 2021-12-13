package com.ragabz.githubapp.data.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ragabz.githubapp.data.local.entities.GithubRepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubRepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg list: GithubRepoEntity)

    @Query("select * from githubrepoentity")
    suspend fun getAllRepos(): List<GithubRepoEntity>
}