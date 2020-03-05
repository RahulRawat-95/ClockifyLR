package com.example.clockifylr

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Lokesh Mudgal on 5/3/20.
 */
interface Api {

    companion object {
        const val BASE_GIT_URL = "https://api.github.com/"
    }

    @GET("repos/vinsol/ulesson-android/commits")
    fun getCommits(
        @Query("access_token") accessToken: String,
        @Query("author") author: String,
        @Query("since") since: String,
        @Query("until") until: String
    ): Call<List<GitCommits>>

}