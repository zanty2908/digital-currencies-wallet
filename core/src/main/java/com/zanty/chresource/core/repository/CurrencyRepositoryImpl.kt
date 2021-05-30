package com.zanty.chresource.core.repository

import com.zanty.chresource.core.executor.PostExecutionThread
import com.zanty.chresource.core.network.flowOfService
import com.zanty.chresource.data.network.service.CurrencyService
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val postExecutionThread: PostExecutionThread,
    private val currencyService: CurrencyService
) : CurrencyRepository {
    override fun getList() = flowOfService(postExecutionThread) {
        currencyService.getPrices()
    }
}
