package com.zanty.chresource.digitalcurrencieswallet.ui.search

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.zanty.chresource.core.extension.hideSoftKeyboard
import com.zanty.chresource.core.extension.onGlobalLayout
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
    private var headerHeight = 0f

    override fun FragmentSearchCurrencyBinding.initViews() {
        viewModel ?: run {
            viewModel = mViewModel

            layoutMain.setSafeOnClickListener { edtSearch.hideSoftKeyboard() }
            layoutHeader.onGlobalLayout { headerHeight = layoutHeader.measuredHeight * 1.5f }

            rvCurrency.adapter = mAdapter
            rvCurrency.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                private var scrollDistance = 0
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    scrollDistance += dy
                    when {
                        dy <= -30 || scrollDistance < 100 -> showAndHideHeader(true)
                        dy >= 30 -> showAndHideHeader(false)
                        dy >= 10 || dy <= -10 -> edtSearch.hideSoftKeyboard()
                    }
                }
            })
        }

        observeData()
    }

    private var isAnimateHeaderRunning = false
    private fun showAndHideHeader(isShow: Boolean) {
        if (isAnimateHeaderRunning) return

        isAnimateHeaderRunning = true
        val value = if (isShow) 0f else -headerHeight
        mBinding.layoutHeader.animate()
            .translationY(value)
            .withEndAction { isAnimateHeaderRunning = false }
            .start()
    }

    private fun observeData() = with(mViewModel) {
        currencyListLive.observe(viewLifecycleOwner) {
            val list = it ?: emptyList()
            mAdapter.submitList(list)
        }
    }

    override fun onPause() {
        super.onPause()
        mBinding.edtSearch.hideSoftKeyboard()
    }

}
