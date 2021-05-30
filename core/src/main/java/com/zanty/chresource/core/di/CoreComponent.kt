package com.zanty.chresource.core.di

import com.squareup.moshi.Moshi
import com.zanty.chresource.core.executor.PostExecutionThread
import com.zanty.chresource.core.repository.CurrencyRepository
import com.zanty.chresource.data.network.service.CurrencyService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CoreComponent {
    val postExecutionThread: PostExecutionThread
    val moshi: Moshi
    val currencyService: CurrencyService
    val currencyRepository: CurrencyRepository
}
