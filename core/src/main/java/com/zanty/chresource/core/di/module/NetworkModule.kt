package com.zanty.chresource.core.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.zanty.chresource.data.network.NetworkFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import com.zanty.chresource.core.BuildConfig
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @[Provides Singleton]
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @[Provides Singleton]
    fun provideHttpClient(): OkHttpClient = NetworkFactory
        .createOkHttpClient(BuildConfig.DEBUG)

    @[Provides Singleton]
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi) = NetworkFactory
        .createRetrofit(
            okHttpClient,
            moshi,
            BuildConfig.BASE_URL
        )

    @[Provides Singleton]
    fun provideDriverService(retrofit: Retrofit) = NetworkFactory.createDriverService(retrofit)

}
