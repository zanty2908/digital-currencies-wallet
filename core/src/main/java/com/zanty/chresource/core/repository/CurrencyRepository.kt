package com.zanty.chresource.core.repository

import com.zanty.chresource.core.model.Currency
import com.zanty.chresource.core.network.BaseResult
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    fun getList(): Flow<BaseResult<List<Currency>>>
}
