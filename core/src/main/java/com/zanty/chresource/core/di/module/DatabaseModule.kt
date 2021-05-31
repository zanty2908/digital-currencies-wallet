package com.zanty.chresource.core.di.module

import android.content.Context
import com.zanty.chresource.data.local.LocalFactory
import com.zanty.chresource.data.local.dao.CurrencyDao
import com.zanty.chresource.data.local.room.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(context: Context) = LocalFactory.makeRoomDatabase(context)

    @[Provides Singleton]
    fun provideCurrentDao(database: MainDatabase): CurrencyDao = database.currencyDao()

}
