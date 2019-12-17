package com.junemon.daggerinmitch.feature.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.junemon.daggerinmitch.R
import com.junemon.daggerinmitch.di.factory.ViewModelProviderFactory
import com.junemon.daggerinmitch.feature.main.viewmodel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    @Inject lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this, providerFactory).get(MainViewModel::class.java)

        setContentView(R.layout.activity_main)
    }
}
