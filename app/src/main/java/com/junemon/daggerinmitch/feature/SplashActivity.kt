package com.junemon.daggerinmitch.feature

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.RequestManager
import com.junemon.daggerinmitch.R
import com.junemon.daggerinmitch.databinding.ActivitySplashBinding
import com.junemon.daggerinmitch.feature.main.view.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject


class SplashActivity : DaggerAppCompatActivity() {
    private val TAG = "SplashActivity"
    private var mDelayHandler: Handler? = null
    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    @Inject
    lateinit var glideRequestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.apply {
            lifecycleOwner = this@SplashActivity
            initView()
        }
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, 3000L)
    }

    private fun ActivitySplashBinding.initView() {
        apply {
            try {
                check(::glideRequestManager.isInitialized) {
                    " glide request is not injected"
                }
                glideRequestManager.load(getDrawable(R.drawable.samarinda_logo)).into(ivSplash)
            } catch (e: IllegalStateException) {
                Timber.tag(TAG).e("initView failed because : ${e.message}")
            }
        }
    }
}