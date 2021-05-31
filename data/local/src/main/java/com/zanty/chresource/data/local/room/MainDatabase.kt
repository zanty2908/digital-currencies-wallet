package com.zanty.chresource.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zanty.chresource.data.local.dao.CurrencyDao
import com.zanty.chresource.data.local.model.Currency

@Database(
    entities = [Currency::class],
    version = 1,
    exportSchema = true
)
abstract class MainDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}
