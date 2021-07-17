package com.kk.hiltsample.network

import com.kk.hiltsample.model.Post
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getApiPost():Post = apiService.getPosts()
}