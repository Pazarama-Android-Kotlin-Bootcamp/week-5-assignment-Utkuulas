package com.merttoptas.retrofittutorial.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.merttoptas.retrofittutorial.data.model.UserDTO
import com.merttoptas.retrofittutorial.databinding.ItemUserLayoutBinding
import com.merttoptas.retrofittutorial.ui.users.UserFragment


class UsersAdapter(private val listener: UserFragment) : ListAdapter<UserDTO, UsersAdapter.UserViewHolder>(UsersDiffUtil()) {

    class UserViewHolder(private val binding: ItemUserLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: UserDTO, listener: onUserClickListener) {
            binding.dataHolder = user
            binding.executePendingBindings()
        }
    }

    class UsersDiffUtil : DiffUtil.ItemCallback<UserDTO>() {
        override fun areItemsTheSame(oldItem: UserDTO, newItem: UserDTO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserDTO, newItem: UserDTO): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

}

interface onUserClickListener {
    fun onUserClick(user: UserDTO) {

    }
}