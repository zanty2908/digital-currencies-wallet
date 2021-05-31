package com.zanty.chresource.digitalcurrencieswallet.ui.search

import androidx.lifecycle.*
import com.zanty.chresource.core.executor.PostExecutionThread
import com.zanty.chresource.core.repository.CurrencyRepository
import com.zanty.chresource.data.local.model.Currency
import com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase.GetPricesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCurrencyViewModel @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val getPricesUseCase: GetPricesUseCase,
    private val currencyRepository: CurrencyRepository
) : ViewModel() {

    val showLoading get() = getPricesUseCase.loadingLive
    val showReloadButton get() = getPricesUseCase.errorLive.map { !it.isNullOrBlank() }

    init {
        getPricesUseCase.fetchPricesFlow.launchIn(viewModelScope)
    }

    // Handle on click
    fun onClickReload() {
        getPricesUseCase.fetchPricesFlow.launchIn(viewModelScope)
    }

    fun switchToFavoriteMode() {
        mSearchViewModeFlow.value = SearchViewMode.FAVORITE
    }

    fun switchToSearchMode() {
        mSearchViewModeFlow.value = SearchViewMode.SEARCH
    }

    // Mode
    private val mSearchViewModeFlow = MutableStateFlow(SearchViewMode.SEARCH)
    private val mFavoriteListFlow get() = currencyRepository.favoriteList.asFlow()

    // Search
    private val mQueryStringFlow = MutableStateFlow("")
    val hasQueryString
        get() = mQueryStringFlow.map { it.isNotBlank() }.asLiveData(viewModelScope.coroutineContext)
    var queryString: String
        get() = mQueryStringFlow.value
        set(value) {
            mQueryStringFlow.value = value
        }

    private val mSearchListFlow = mQueryStringFlow
        .combine(getPricesUseCase.resultListLive.asFlow()) { query, list ->
            if (query.isBlank()) list
            else list.filter { it.contains(query) }
        }
        .flowOn(postExecutionThread.io)

    val currencyListLive = mSearchViewModeFlow
        .flatMapLatest {
            when (it) {
                SearchViewMode.SEARCH -> mSearchListFlow
                SearchViewMode.FAVORITE -> mFavoriteListFlow
            }
        }
        .asLiveData(viewModelScope.coroutineContext)

    val emptyList get() = currencyListLive.map { it.isEmpty() }

    fun addCurrencyToFavoriteList(item: Currency) {
        viewModelScope.launch { currencyRepository.insertOrDeleteCurrencyToFavorite(item) }
    }

}
