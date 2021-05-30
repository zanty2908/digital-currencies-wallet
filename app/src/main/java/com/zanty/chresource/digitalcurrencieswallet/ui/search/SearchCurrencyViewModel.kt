package com.zanty.chresource.digitalcurrencieswallet.ui.search

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.zanty.chresource.digitalcurrencieswallet.model.Currency
import com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase.GetPricesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class SearchCurrencyViewModel @Inject constructor(
    private val getPricesUseCase: GetPricesUseCase
) : ViewModel() {

    val currencyListLive: LiveData<List<Currency>> get() = getPricesUseCase.resultListLive
    val showLoading
        get() = getPricesUseCase.loadingLive
            .map { if (it) View.VISIBLE else View.GONE }
    val showReloadButton
        get() = getPricesUseCase.errorLive
            .map { if (it.isNullOrBlank()) View.GONE else View.VISIBLE }

    init {
        getPricesUseCase.fetchPricesFlow.launchIn(viewModelScope)
    }

    fun onClickReload(view: View) {
        getPricesUseCase.fetchPricesFlow.launchIn(viewModelScope)
    }

}
