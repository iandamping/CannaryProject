package com.junemon.daggerinmitch.feature.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.junemon.daggerinmitch.R
import com.junemon.daggerinmitch.base.BaseActivity
import com.junemon.daggerinmitch.base.ResultToConsume
import com.junemon.daggerinmitch.databinding.ActivityMainBinding
import com.junemon.daggerinmitch.di.factory.ViewModelProviderFactory
import com.junemon.daggerinmitch.feature.main.viewmodel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {
    private lateinit var mainViewModel: MainViewModel
    private val adapter: MainAdapter by lazy { MainAdapter() }
    @Inject lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel = ViewModelProvider(this, providerFactory).get(MainViewModel::class.java)
        mainViewModel.getData()
        binding.apply {
            lifecycleOwner = this@MainActivity
            initView()
        }
        setBaseDialog(this)
    }

    private fun ActivityMainBinding.initView(){
        apply {
            mainViewModel.observeGame.observe(this@MainActivity, Observer {result ->
                when(result.status){
                    ResultToConsume.Status.ERROR -> {
                        setDialogShow(true)
                    }
                    ResultToConsume.Status.SUCCESS -> {
                        setDialogShow(true)
                        adapter.submitList(result.data)
                    }
                    else ->{
                        setDialogShow(false)
                    }
                }
            })
            rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            rvMain.adapter = adapter
        }

    }
}
