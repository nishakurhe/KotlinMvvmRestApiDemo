package com.example.kotlinmvvmrestapidemo.api

import com.example.kotlinmvvmrestapidemo.models.SuperHero
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("marvel")
    fun getSuperHeros(): Call<List<SuperHero>>
}