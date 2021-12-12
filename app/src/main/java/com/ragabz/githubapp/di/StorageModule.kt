package com.ragabz.githubapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
    /**
     * Provide shared preference
     *
     * @param context
     * @return
     */
//    @Singleton
//    @Provides
//    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
//        return context.getSharedPreferences(
//            DataManager.PREF_NAME,
//            Context.MODE_PRIVATE
//        )
//    }

    /**
     * Provide session manager
     *
     * @param sharedPreferences
     * @return
     */

//    @Singleton
//    @Provides
//    fun provideSessionManager(sharedPreferences: SharedPreferences): DataManager {
//        return DataManager(sharedPreferences)
//    }
}
