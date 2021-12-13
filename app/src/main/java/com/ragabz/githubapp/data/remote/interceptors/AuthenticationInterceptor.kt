package com.ragabz.githubapp.data.remote.interceptors

import com.ragabz.githubapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor(
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()
        builder.addHeader("token", "${BuildConfig.personal_access_token}")
        return chain.proceed(builder.method(original.method, original.body).build())
    }
}
