package com.example.basearchitecturemvvm.data.service

import com.example.basearchitecturemvvm.BuildConfig
import com.example.basearchitecturemvvm.data.service.adapter.CustomCallAdapterFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Copyright © 2020 SupremeTech inc.
 * Created by HungTran.V on 2020-05-26.
 */
class ApiClient {

    companion object : SingletonHolder<ApiClient>(::ApiClient) {
        private const val API_TIMEOUT = 1L // 1 minutes
    }

    val getService: ApiService
        get() {
            return createService()
        }

    private fun createService(): ApiService {
        val httpClientBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        val client = httpClientBuilder
            .connectTimeout(API_TIMEOUT, TimeUnit.MINUTES)
            .writeTimeout(API_TIMEOUT, TimeUnit.MINUTES)
            .readTimeout(API_TIMEOUT, TimeUnit.MINUTES)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val gs = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create(gs))
            .addCallAdapterFactory(CustomCallAdapterFactory())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}

open class SingletonHolder<out T>(private var creator: () -> T) {
    @kotlin.jvm.Volatile
    private var instance: T? = null

    /**
     * Generate instance for T class with argument A
     */
    fun getInstance(): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator()
                instance = created
                created
            }
        }
    }
}