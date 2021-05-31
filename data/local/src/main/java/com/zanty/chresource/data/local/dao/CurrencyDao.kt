package com.zanty.chresource.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zanty.chresource.data.local.model.Currency

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM Currency")
    fun getFavoriteListLive(): LiveData<List<Currency>>

    @Query("SELECT * FROM Currency")
    suspend fun getFavoriteList(): List<Currency>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Currency)

    @Update
    suspend fun update(item: Currency)

    @Query("DELETE FROM Currency WHERE base = :base")
    suspend fun delete(base: String)

    @Query("DELETE FROM Currency")
    suspend fun delete()

}
