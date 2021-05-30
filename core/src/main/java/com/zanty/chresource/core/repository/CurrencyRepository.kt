package com.zanty.chresource.core.repository

import com.zanty.chresource.core.network.BaseResult
import com.zanty.chresource.data.network.model.response.GetPricesResponse
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    fun getList(): Flow<BaseResult<GetPricesResponse?>>
}
