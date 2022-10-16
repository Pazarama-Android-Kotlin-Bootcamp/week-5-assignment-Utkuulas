package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.api.ApiService
import com.merttoptas.retrofittutorial.data.model.Post
import retrofit2.Call
import retrofit2.Response

/**
 * Created by merttoptas on 16.10.2022.
 */

class PostRepositoryImpl constructor(
    private val apiService:
    ApiService
) : PostRepository {
    override fun getPosts(): Call<List<Post>> {
        return apiService.getPosts()
    }
}