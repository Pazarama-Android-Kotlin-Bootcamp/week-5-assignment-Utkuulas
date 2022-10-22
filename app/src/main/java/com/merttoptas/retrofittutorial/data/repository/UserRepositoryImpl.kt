package com.merttoptas.retrofittutorial.data.repository

import com.merttoptas.retrofittutorial.data.local.database.UsersDatabase
import com.merttoptas.retrofittutorial.data.local.database.entity.UserEntity
import com.merttoptas.retrofittutorial.data.model.User
import com.merttoptas.retrofittutorial.data.remote.api.ApiService
import retrofit2.Call

class UserRepositoryImpl constructor(
    private val apiService: ApiService,
    private val usersDatabase: UsersDatabase
) : UserRepository {
    override fun getUsers(): Call<List<User>> {
        return apiService.getUsers()
    }

    override fun getUserById(id: Int): UserEntity? {
        return usersDatabase.userDao().getUserById(id.toString())
    }
}