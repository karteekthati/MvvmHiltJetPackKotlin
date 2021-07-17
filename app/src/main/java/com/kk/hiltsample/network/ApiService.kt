package com.kk.hiltsample.network

import com.kk.hiltsample.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts():Post
}