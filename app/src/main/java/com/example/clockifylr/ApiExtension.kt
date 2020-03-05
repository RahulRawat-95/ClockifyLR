package com.example.clockifylr

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response

/**
 * Created by Lokesh Mudgal on 5/3/20.
 */

inline fun <reified T> Response<T>.convertToError(gson: Gson): T? {
    return try {
        val errorBody = errorBody()!!.string()
        val classType = object : TypeToken<T>() {}.type
        gson.fromJson(errorBody, classType) as? T
    } catch (e: Exception) {
        null
    }
}