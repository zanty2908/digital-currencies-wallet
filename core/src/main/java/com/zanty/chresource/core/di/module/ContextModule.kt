package com.zanty.chresource.core.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface ContextModule {

    @get:Binds
    val Application.bindContext: Context

}
