package com.merttoptas.retrofittutorial.data.di

import android.content.Context
import com.merttoptas.retrofittutorial.data.local.database.PostsDatabase
import com.merttoptas.retrofittutorial.data.local.database.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by merttoptas on 17.10.2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    // Room Database
    // Dao
    //DataStoreManager
    //SharedPreferences

    @Provides
    @Singleton
    fun providePostsDatabase(@ApplicationContext appContext: Context): PostsDatabase {
        return PostsDatabase.getDatabase(appContext)
    }

//    @Provides
//    @Singleton
//    fun provideUsersDatabase(@ApplicationContext appContext: Context): UsersDatabase {
//        return UsersDatabase.getUsersDatabase(appContext)
//    }

    @Singleton
    @Provides
    fun providePostDao(db: PostsDatabase) = db.postDao()

    @Singleton
    @Provides
    fun provideUserDao(db: UsersDatabase) = db.userDao()
}