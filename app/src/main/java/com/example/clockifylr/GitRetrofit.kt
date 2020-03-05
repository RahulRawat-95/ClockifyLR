package com.example.clockifylr

import com.example.clockifylr.Api.Companion.BASE_GIT_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Lokesh Mudgal on 5/3/20.
 */
object GitRetrofit {

    val api: Api by lazy {
        Retrofit.Builder().baseUrl(BASE_GIT_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().serializeNulls().create()
                )
            )
            .build().create(Api::class.java)
    }
}