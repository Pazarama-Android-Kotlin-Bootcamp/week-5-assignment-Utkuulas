package com.merttoptas.retrofittutorial.ui.users.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.merttoptas.retrofittutorial.data.repository.UserRepository

@Deprecated("Use ViewModelFactory from Hilt")
class UserViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(userRepository) as T
    }
}