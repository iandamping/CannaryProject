package com.junemon.daggerinmitch.view

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.RequestManager
import com.junemon.daggerinmitch.R
import com.junemon.daggerinmitch.databinding.ActivitySplashBinding
import dagger.android.DaggerActivity
import java.lang.IllegalStateException
import javax.inject.Inject

class SplashActivity : DaggerActivity() {
    private val TAG = "SplashActivity"
    @Inject
    lateinit var glideRequestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.apply {
            initView()
        }
    }

    private fun ActivitySplashBinding.initView() {
        apply {
            try {
                check(::glideRequestManager.isInitialized) {
                    " glide request is not injected"
                }
                glideRequestManager.load(getDrawable(R.drawable.samarinda_logo)).into(ivSplash)
            } catch (e: IllegalStateException) {
                Log.e(TAG, "initView failed because : ${e.message}")
            }
        }
    }
}