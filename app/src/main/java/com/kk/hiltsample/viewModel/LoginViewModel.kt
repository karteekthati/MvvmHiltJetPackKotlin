package com.kk.hiltsample.viewModel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kk.hiltsample.Utils.Helper
import com.kk.hiltsample.model.LoginModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(@ApplicationContext private val context: Context,
                                         private val helper: Helper,) : ViewModel(){

    var userMutableLiveData =  MutableLiveData<LoginModel>(LoginModel())
    private val liveData: LiveData<LoginModel> = userMutableLiveData



    fun  login(view: View){
        Log.d("TAG", "reached login")
        if(liveData.value?.username.isNullOrEmpty()){
            // helper.toast(context, "username is empty")
            helper.log("username is empty")
        }
        else if(liveData.value?.password.isNullOrEmpty()){
            // helper.toast(context, "password is empty")
            helper.log("password is empty")
        }
        else{
            helper.log("username is empty")
            // Log.d("Mvvm","store login details")
        }

    }
}