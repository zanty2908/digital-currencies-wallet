package com.zanty.chresource.digitalcurrencieswallet.ui.search

import androidx.lifecycle.*
import com.zanty.chresource.core.executor.PostExecutionThread
import com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase.GetPricesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class SearchCurrencyViewModel @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val getPricesUseCase: GetPricesUseCase
) : ViewModel() {

    val showLoading get() = getPricesUseCase.loadingLive
    val showReloadButton get() = getPricesUseCase.errorLive.map { !it.isNullOrBlank() }

    init {
        getPricesUseCase.fetchPricesFlow.launchIn(viewModelScope)
    }

    fun onClickReload() {
        getPricesUseCase.fetchPricesFlow.launchIn(viewModelScope)
    }

    private val queryStringFlow = MutableStateFlow("")
    var queryString: String
        get() = queryStringFlow.value
        set(value) {
            queryStringFlow.value = value
        }
    val currencyListLive = queryStringFlow
        .combine(getPricesUseCase.resultListLive.asFlow()) { query, list ->
            if (query.isBlank()) list to false
            else list.filter { it.contains(query) } to true
        }
        .flowOn(postExecutionThread.io)
        .asLiveData(viewModelScope.coroutineContext)

    val emptyList get() = currencyListLive.map { (list, hasQuery) -> list.isEmpty() && hasQuery }

}
