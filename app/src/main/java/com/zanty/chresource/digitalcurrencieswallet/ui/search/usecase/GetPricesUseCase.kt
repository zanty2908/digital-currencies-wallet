package com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.zanty.chresource.core.network.BaseResult
import com.zanty.chresource.core.repository.CurrencyRepository
import com.zanty.chresource.data.network.model.response.CurrencyResponse
import com.zanty.chresource.data.network.model.response.GetPricesResponse
import com.zanty.chresource.digitalcurrencieswallet.model.Currency
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retryWhen
import javax.inject.Inject

class GetPricesUseCase @Inject constructor(currencyRepository: CurrencyRepository) {

    private val mPricesResultLive = MutableLiveData<BaseResult<Any?>>()
    val resultListLive: LiveData<List<Currency>> = mPricesResultLive
        .map {
            if (it !is BaseResult.Success) return@map emptyList()
            val resultList = it.data as? GetPricesResponse ?: return@map emptyList()
            resultList.mapToDomain()
        }
    val loadingLive: LiveData<Boolean> = mPricesResultLive.map { it is BaseResult.Loading }
    val errorLive: LiveData<String?> = mPricesResultLive.map {
        when (it) {
            is BaseResult.Failed -> it.message
            is BaseResult.Error -> it.error.message
            else -> null
        }
    }

    val fetchPricesFlow = currencyRepository.getList()
        .onEach { mPricesResultLive.postValue(it) }
        .retryWhen { cause, attempt ->
            (cause is Exception && attempt < 5)
                .also { if (it) delay(1000) }
        }

    // Mapping data
    private fun GetPricesResponse?.mapToDomain(): List<Currency> {
        val data = this?.data ?: return emptyList()
        return data.mapNotNull { it?.mapToDomain() }
    }

    private fun CurrencyResponse?.mapToDomain(): Currency? {
        val base = this?.base ?: return null
        return Currency(
            name ?: "",
            base,
            buyPrice ?: 0.0,
            sellPrice ?: 0.0,
            icon ?: "",
            counter ?: ""
        )
    }

}
