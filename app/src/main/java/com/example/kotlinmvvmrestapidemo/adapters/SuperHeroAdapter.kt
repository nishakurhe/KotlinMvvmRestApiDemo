package com.example.kotlinmvvmrestapidemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmrestapidemo.adapters.SuperHeroAdapter.SuperHeroViewHolder
import com.example.kotlinmvvmrestapidemo.databinding.LaySuperheroItemBinding
import com.example.kotlinmvvmrestapidemo.models.SuperHero

class SuperHeroAdapter(private val superHeroList:List<SuperHero>):RecyclerView.Adapter<SuperHeroViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(LaySuperheroItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.binding.superhero = superHeroList[position]
    }

    override fun getItemCount(): Int = superHeroList.size

    inner class SuperHeroViewHolder(val binding: LaySuperheroItemBinding):RecyclerView.ViewHolder(binding.root)
}