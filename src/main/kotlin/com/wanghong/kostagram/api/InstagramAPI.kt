/*
 * Copyright (C) 2018 mutter
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wanghong.kostagram.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by mutter on 2/7/18.
 */
object InstagramAPI {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val accessTokenInterceptor = Interceptor {
        val request = it.request()
        val url = request.url().newBuilder().addQueryParameter("access_token", EndPoints.ACCESS_TOKEN).build()
        it.proceed(request.newBuilder().url(url).build())
    }

    private val client = OkHttpClient.Builder()
            .addNetworkInterceptor(accessTokenInterceptor)
            .addInterceptor(loggingInterceptor).build()

    private val api = Retrofit.Builder().baseUrl(EndPoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(InstagramService::class.java)

    private val authClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor).build()

    private val authService = Retrofit.Builder()
            .baseUrl("https://api.instagram.com/")
            .client(authClient)
            .build()
            .create(AuthenticationService::class.java)

    fun getService(): InstagramService {
        return api
    }

    fun getAuthService(): AuthenticationService {
        return authService
    }
}