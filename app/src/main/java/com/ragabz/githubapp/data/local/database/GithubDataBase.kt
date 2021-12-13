package com.ragabz.githubapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ragabz.githubapp.data.local.dao.GithubRepoDao
import com.ragabz.githubapp.data.local.entities.GithubRepoEntity

const val DATABASE_NAME = "github_app_db"


@Database(entities = [GithubRepoEntity::class], version = 1)
abstract class GithubDataBase : RoomDatabase() {

    abstract fun repoDao(): GithubRepoDao

    companion object {
        fun getDataBase(context: Context) = Room
            .databaseBuilder(
                context,
                GithubDataBase::class.java,
                DATABASE_NAME
            ).build()

    }
}