package dev.andrewjap.nontonmovie.data.interceptor

import dev.andrewjap.nontonmovie.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return request.url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.MOVIE_API_KEY)
            .build()
            .let { chain.proceed(request.newBuilder().url(it).build()) }
    }
}