package com.merttoptas.retrofittutorial.data.di

import com.merttoptas.retrofittutorial.data.local.database.PostsDatabase
import com.merttoptas.retrofittutorial.data.remote.api.ApiService
import com.merttoptas.retrofittutorial.data.repository.PostRepository
import com.merttoptas.retrofittutorial.data.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

/**
 * Created by merttoptas on 17.10.2022.
 */

@Module
@InstallIn(ViewModelComponent::class)
class PostsModule {
    // Api Service Class
    // Repository and DataSource Impl
    // Database

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providePostRepository(apiService: ApiService, postsDatabase: PostsDatabase) : PostRepository {
        return PostRepositoryImpl(apiService, postsDatabase)
    }
}