package com.ragabz.githubapp.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ragabz.githubapp.BuildConfig
import com.ragabz.githubapp.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Timber.i("personal access token: ${BuildConfig.personal_access_token}")
    }
}