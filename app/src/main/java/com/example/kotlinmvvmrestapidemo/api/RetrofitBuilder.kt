package com.example.kotlinmvvmrestapidemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val baseUrl = "https://www.simplifiedcoding.net/demos/"

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiService : ApiService = getRetrofit().create(ApiService::class.java)
}