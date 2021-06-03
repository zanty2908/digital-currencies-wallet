package com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.zanty.chresource.core.executor.PostExecutionThread
import com.zanty.chresource.core.network.BaseResult
import com.zanty.chresource.core.repository.CurrencyRepository
import com.zanty.chresource.data.local.model.Currency
import com.zanty.chresource.digitalcurrencieswallet.ui.search.mapper.CurrencyMapper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retryWhen
import javax.inject.Inject

class GetPricesUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    currencyRepository: CurrencyRepository,
    private val currencyMapper: CurrencyMapper
) {

    private val mPricesResultLive = MutableLiveData<BaseResult<Any?>>()
    val loadingLive: LiveData<Boolean> = mPricesResultLive.map { it is BaseResult.Loading }
    val errorLive: LiveData<String?> = mPricesResultLive.map {
        when (it) {
            is BaseResult.Failed -> it.message
            is BaseResult.Error -> it.error.message
            else -> null
        }
    }
    val resultListLive = MutableLiveData<List<Currency>>()

    val fetchPricesFlow = currencyRepository.getList()
        .onEach {
            if (it is BaseResult.Success) {
                val resultList = it.data
                    .mapNotNull(currencyMapper::mapFromResponse)
                    .sortedByDescending { item -> item.buyPrice }

                currencyRepository.updateFavorite(resultList)
                resultListLive.postValue(resultList)
            }
            mPricesResultLive.postValue(it)
        }
        .retryWhen { cause, attempt ->
            (cause is Exception && attempt < 5)
                .also { if (it) delay(1000) }
        }
        .flowOn(postExecutionThread.io)

}
