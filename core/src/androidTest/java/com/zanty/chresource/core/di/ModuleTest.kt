package com.zanty.chresource.core.di

import android.content.Context
import androidx.room.Room
import com.zanty.chresource.data.local.room.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Named


@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CoreComponent::class]
)
class ModuleTest {
    @Provides
    @Named("test_db")
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, MainDatabase::class.java).allowMainThreadQueries().build()
}
