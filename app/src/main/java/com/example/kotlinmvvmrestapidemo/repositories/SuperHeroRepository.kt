package com.example.kotlinmvvmrestapidemo.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmrestapidemo.api.RetrofitBuilder.apiService
import com.example.kotlinmvvmrestapidemo.models.SuperHero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperHeroRepository {

    private var dataSet:MutableLiveData<List<SuperHero>> = MutableLiveData()
    private var isDataFetch:MutableLiveData<Boolean> = MutableLiveData()
    private var instance: SuperHeroRepository ?= null

    fun getRepoInstance() : SuperHeroRepository{
        if (instance == null) instance = SuperHeroRepository()
        return instance!!
    }

    // Do api calls OR get data from web service OR database operations here

    fun getSuperHeroList(): Pair<MutableLiveData<List<SuperHero>>, MutableLiveData<Boolean>> {

        isDataFetch.value = true
        val retrofitCall = apiService.getSuperHeros()

        retrofitCall.enqueue(object : Callback<List<SuperHero>>{

            override fun onResponse(call: Call<List<SuperHero>>, response: Response<List<SuperHero>>) {
                dataSet.value = response.body()!!
                isDataFetch.value = false
                Log.e("res==", "onResponse() Data fetch..")
            }

            override fun onFailure(call: Call<List<SuperHero>>, t: Throwable) {
                isDataFetch.value = false
                Log.e("res==", "Exception onFailure()  retrofit error...")
            }

        })

        return Pair(dataSet,isDataFetch)
    }
}