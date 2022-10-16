package com.merttoptas.retrofittutorial.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by merttoptas on 8.10.2022.
 */

class ApiClient {
    companion object {
        private lateinit var apiService: ApiService

        @JvmName("getApiService1")
        fun getApiService(): ApiService {
            if (!::apiService.isInitialized) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService
        }
    }
}