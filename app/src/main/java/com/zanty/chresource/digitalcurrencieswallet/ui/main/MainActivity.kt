package com.zanty.chresource.digitalcurrencieswallet.ui.main

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.zanty.chresource.digitalcurrencieswallet.R
import com.zanty.chresource.digitalcurrencieswallet.databinding.ActivityMainBinding
import com.zanty.chresource.digitalcurrencieswallet.di.injectComponent
import com.zanty.chresource.digitalcurrencieswallet.ui.search.SearchCurrencyFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.run {
            lifecycleOwner = this@MainActivity

            ValueAnimator.ofFloat(0.3f, 1f)
                .apply {
                    duration = 700L
                    repeatCount = 3
                    repeatMode = ValueAnimator.REVERSE
                    addUpdateListener {
                        ivLogo.alpha = it.animatedValue as Float
                    }
                    doOnEnd {
                        replaceSearchFragment()
                        ivLogo.isVisible = false
                    }
                }
                .start()
        }
    }

    private fun replaceSearchFragment() {
        supportFragmentManager.commit(true) {
            replace(R.id.container, SearchCurrencyFragment(), "Search")
            addToBackStack(null)
        }
    }

    override fun onBackPressed() {
        finish()
    }

}
