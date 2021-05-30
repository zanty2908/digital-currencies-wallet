package com.zanty.chresource.digitalcurrencieswallet.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zanty.chresource.core.model.Currency
import com.zanty.chresource.core.network.BaseResult
import com.zanty.chresource.core.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.retryWhen
import javax.inject.Inject

@HiltViewModel
class SearchCurrencyViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : ViewModel() {

    private val mCurrencyListLive = MutableLiveData<List<Currency>>()
    val currencyLive: LiveData<List<Currency>> get() = mCurrencyListLive

    init {
        fetchCurrencies()
    }

    private fun fetchCurrencies() {
        currencyRepository.getList()
            .onEach {
                Log.e("MAIN", "fetchCurrencies: $it")
                if (it is BaseResult.Success) mCurrencyListLive.postValue(it.data)
            }
            .retryWhen { cause, attempt ->
                (cause is Exception && attempt < 5)
                    .also { if (it) delay(1000) }
            }
            .launchIn(viewModelScope)
    }

}
