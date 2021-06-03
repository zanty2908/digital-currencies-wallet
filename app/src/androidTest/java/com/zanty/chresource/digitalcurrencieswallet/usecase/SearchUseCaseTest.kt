package com.zanty.chresource.digitalcurrencieswallet.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.zanty.chresource.digitalcurrencieswallet.fake.DummyData
import com.zanty.chresource.digitalcurrencieswallet.ui.search.usecase.SearchUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
class SearchUseCaseTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var searchUseCase: SearchUseCase

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun checkSearch() = runBlockingTest {
        val currencyList = DummyData.currencyList
        val query = "L"
        val resultList = searchUseCase.searchResultList(currencyList)(query)

        assertThat(resultList[0].base).isEqualTo(currencyList[0].base)
        assertThat(resultList[1].base).isEqualTo(currencyList[3].base)
    }

    @Test
    fun checkSearchWithPrefix() = runBlockingTest {
        val currencyList = DummyData.currencyList
        val query = "C"
        val resultList = searchUseCase.searchResultList(currencyList)(query)

        assertThat(resultList[0].base).isEqualTo(currencyList[4].base)
        assertThat(resultList[1].base).isEqualTo(currencyList[0].base)
        assertThat(resultList[2].base).isEqualTo(currencyList[2].base)
    }

}
