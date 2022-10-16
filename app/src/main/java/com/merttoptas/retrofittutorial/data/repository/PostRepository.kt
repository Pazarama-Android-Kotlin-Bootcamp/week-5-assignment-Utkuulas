package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.model.Post
import retrofit2.Call

/**
 * Created by merttoptas on 16.10.2022.
 */

interface PostRepository {
    fun getPosts(): Call<List<Post>>
}