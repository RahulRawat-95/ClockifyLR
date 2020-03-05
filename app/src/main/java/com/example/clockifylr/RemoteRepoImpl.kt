package com.example.clockifylr

import android.util.Log
import com.example.clockifylr.GitRetrofit.api
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

/**
 * Created by Lokesh Mudgal on 5/3/20.
 */

object RemoteRepoImpl {

    private val gson = GsonBuilder().serializeNulls().create()

    fun getCommits(
        accessToken: String,
        author: String,
        since: String,
        until: String,
        onSuccess: (list: List<GitCommits>) -> Unit,
        onFailure: (errorMsg: String?) -> Unit
    ) {
        val gitRequest = api.getCommits(accessToken, author, since, until)
        Log.e("AlucarD", gitRequest.request().url().toString())
        gitRequest.enqueue(
            object : retrofit2.Callback<List<GitCommits>> {
                override fun onFailure(call: Call<List<GitCommits>>, t: Throwable) {
                    onFailure("")
                }

                override fun onResponse(
                    call: Call<List<GitCommits>>,
                    response: Response<List<GitCommits>>
                ) {
                    val responseJson = response.body()
                    when {
                        response.isSuccessful && responseJson != null -> {
                            onSuccess(responseJson)
                        }
                        else -> {
                            val errorResponse = response.convertToError(gson)
                            onFailure(errorResponse?.toString())
                        }
                    }
                }
            }
        )

    }
}