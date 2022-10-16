package com.merttoptas.retrofittutorial.ui.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.merttoptas.retrofittutorial.data.repository.PostRepository

/**
 * Created by merttoptas on 16.10.2022.
 */

class PostViewModelFactory(private val postRepository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(postRepository) as T
    }
}