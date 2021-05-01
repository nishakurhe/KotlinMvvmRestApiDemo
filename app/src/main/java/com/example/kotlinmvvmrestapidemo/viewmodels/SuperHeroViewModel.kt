package com.example.kotlinmvvmrestapidemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmrestapidemo.models.SuperHero
import com.example.kotlinmvvmrestapidemo.repositories.SuperHeroRepository

class SuperHeroViewModel :ViewModel(){

    var mSuperHeros:MutableLiveData<List<SuperHero>> ?= null
    var isDownloading:MutableLiveData<Boolean> = MutableLiveData()
    private lateinit var mRepository: SuperHeroRepository

    fun init(){
        if (mSuperHeros != null) mSuperHeros
        else mSuperHeros = MutableLiveData()

        mRepository = SuperHeroRepository().getRepoInstance()

        //mSuperHeros = mRepository.getSuperHeroList()
       val  (a,b) = mRepository.getSuperHeroList()
        mSuperHeros = a
        isDownloading = b
    }
}