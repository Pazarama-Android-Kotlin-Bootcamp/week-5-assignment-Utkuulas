package com.merttoptas.retrofittutorial.data.di


import com.merttoptas.retrofittutorial.data.local.database.UsersDatabase
import com.merttoptas.retrofittutorial.data.remote.api.ApiService

import com.merttoptas.retrofittutorial.data.repository.UserRepository
import com.merttoptas.retrofittutorial.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class UsersModule {

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideUserRepository(apiService: ApiService, usersDatabase: UsersDatabase) : UserRepository {
        return UserRepositoryImpl(apiService, usersDatabase)
    }
}