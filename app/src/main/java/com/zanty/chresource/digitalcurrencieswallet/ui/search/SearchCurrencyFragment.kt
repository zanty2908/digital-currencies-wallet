package com.zanty.chresource.digitalcurrencieswallet.ui.search

import androidx.fragment.app.viewModels
import com.zanty.chresource.core.extension.hideSoftKeyboard
import com.zanty.chresource.core.extension.setSafeOnClickListener
import com.zanty.chresource.digitalcurrencieswallet.R
import com.zanty.chresource.digitalcurrencieswallet.base.BaseFragment
import com.zanty.chresource.digitalcurrencieswallet.databinding.FragmentSearchCurrencyBinding
import com.zanty.chresource.digitalcurrencieswallet.di.injectComponent
import com.zanty.chresource.digitalcurrencieswallet.ui.search.adapter.CurrencyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchCurrencyFragment : BaseFragment<FragmentSearchCurrencyBinding>(
    R.layout.fragment_search_currency
) {

    override fun initDependencyInjection() = injectComponent()

    private val mViewModel: SearchCurrencyViewModel by viewModels()

    private val mAdapter: CurrencyAdapter by lazy { CurrencyAdapter() }

    override fun FragmentSearchCurrencyBinding.initViews() {
        viewModel ?: run {
            viewModel = mViewModel

            layoutMain.setSafeOnClickListener { edtSearch.hideSoftKeyboard() }

            rvCurrency.adapter = mAdapter
        }
        observeData()
    }

    private fun observeData() = with(mViewModel) {
        currencyLive.observe(viewLifecycleOwner) {
            val list = it ?: emptyList()
            mAdapter.submitList(list)
        }
    }

    override fun onPause() {
        super.onPause()
        mBinding.edtSearch.hideSoftKeyboard()
    }

}
