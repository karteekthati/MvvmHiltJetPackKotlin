package com.kk.hiltsample.Utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


class Helper @Inject constructor(){

    fun toast(context: Context, msg:String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT)
    }
    fun log(msg: String){
        Log.d("MvvmHilt", msg)
    }
}