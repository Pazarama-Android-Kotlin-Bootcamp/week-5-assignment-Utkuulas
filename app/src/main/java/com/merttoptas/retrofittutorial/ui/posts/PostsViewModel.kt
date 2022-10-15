package com.merttoptas.retrofittutorial.ui.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merttoptas.retrofittutorial.data.api.ApiClient
import com.merttoptas.retrofittutorial.data.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by merttoptas on 15.10.2022.
 */

class PostsViewModel : ViewModel() {
    val postLiveData = MutableLiveData<List<Post>>()
    val errorLiveData = MutableLiveData<String>()

    init {
        getPosts()
    }

    private fun getPosts() {
        ApiClient.getApiService().getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    post?.let { safePosts ->
                        postLiveData.value = safePosts
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                errorLiveData.value = t.message
            }
        })
    }
}