package com.junemon.daggerinmitch.feature.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.junemon.daggerin.network.ApiInterface
import javax.inject.Inject

class MainViewModel @Inject constructor(private val api:ApiInterface): ViewModel() {
    private val TAG = "SplashViewModel"

    init {
        Log.d(TAG, "this view model is injected")
        Log.d(TAG, "$api berhasil create")
    }
}