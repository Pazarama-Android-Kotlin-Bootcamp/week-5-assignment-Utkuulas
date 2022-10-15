package com.merttoptas.retrofittutorial.ui.posts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.merttoptas.retrofittutorial.data.api.ApiClient
import com.merttoptas.retrofittutorial.data.model.Post
import com.merttoptas.retrofittutorial.databinding.FragmentPostsBinding
import com.merttoptas.retrofittutorial.ui.posts.adapter.PostsAdapter
import retrofit2.Call
import retrofit2.Response

class PostsFragment : Fragment() {
    private lateinit var binding: FragmentPostsBinding
    private val viewModel by viewModels<PostsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.postLiveData.observe(viewLifecycleOwner) {
            binding.rvPostsList.adapter = PostsAdapter().apply {
                submitList(it)
            }
        }
    }
}