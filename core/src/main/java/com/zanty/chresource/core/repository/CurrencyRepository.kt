package com.zanty.chresource.core.repository

import androidx.lifecycle.LiveData
import com.zanty.chresource.core.network.BaseResult
import com.zanty.chresource.data.local.model.Currency
import com.zanty.chresource.data.network.model.response.GetPricesResponse
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    fun getList(): Flow<BaseResult<GetPricesResponse?>>

    val favoriteList: LiveData<List<Currency>>

    suspend fun insertOrDeleteCurrencyToFavorite(item: Currency)

    suspend fun updateFavorite(currencies: List<Currency>)

}
