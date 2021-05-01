package com.example.kotlinmvvmrestapidemo.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


/*
   Here we haven’t used the @SerializedName annotation since we have declared the same variable name as that of the server response field.
    However,  if you wish to change the variable name of the data class, you can do so by adding the annotation like
    @SerializedName("firstappearance")
   val firstAppearance:String,
   */

data class SuperHero(
    val name:String,
    val realname:String,
    val team:String,
    val firstappearance:String,
    val createdby:String,
    val publisher:String,
    val  imageurl:String,
    val bio:String)
{
    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic
        fun ImageView.loadImageFromNet(url: String) {
            Glide.with(this).load(url).into(this)
        }
    }

}