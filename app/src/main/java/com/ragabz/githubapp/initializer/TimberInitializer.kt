package com.ragabz.githubapp.initializer

import android.content.Context
import androidx.startup.Initializer
import com.ragabz.githubapp.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.d("TimberInitializer --> initialized")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}
