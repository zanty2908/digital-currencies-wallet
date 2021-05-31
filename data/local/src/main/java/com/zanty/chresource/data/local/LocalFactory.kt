package com.zanty.chresource.data.local

import android.content.Context
import androidx.room.Room
import com.zanty.chresource.data.local.room.MainDatabase

object LocalFactory {
    private const val DATABASE_NAME = "ch_resource_local_db"

    fun makeRoomDatabase(context: Context): MainDatabase = Room
        .databaseBuilder(
            context,
            MainDatabase::class.java,
            DATABASE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()
}
