package com.example.callproject

import android.media.Image
import android.util.Log

data class MyItem(val profile: Int, val name:String?=null, val number:String,var checkbox:Boolean=false) {
    val Tag:String="log"

    init{
        Log.d(Tag,"MyItem -init() called")
    }
}