package com.kk.hiltsample.Utils

import com.kk.hiltsample.model.Post


sealed class ApiState{
    object Loading: ApiState()
    class Failure(val msg:Throwable): ApiState()
    class Success(val data: Post): ApiState()
    object Empty: ApiState()
}
