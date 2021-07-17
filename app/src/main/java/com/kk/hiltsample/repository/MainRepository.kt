package com.kk.hiltsample.repository

import com.kk.hiltsample.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiServieImpl: ApiServiceImpl) {

    fun getRepoPost() = flow {
        emit(apiServieImpl.getApiPost())
    }.flowOn(
        Dispatchers.IO
    )
}