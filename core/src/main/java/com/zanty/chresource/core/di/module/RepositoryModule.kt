package com.zanty.chresource.core.di.module

import com.zanty.chresource.core.repository.CurrencyRepository
import com.zanty.chresource.core.repository.CurrencyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @get:[Binds Singleton]
    val CurrencyRepositoryImpl.homeRepository: CurrencyRepository

}
