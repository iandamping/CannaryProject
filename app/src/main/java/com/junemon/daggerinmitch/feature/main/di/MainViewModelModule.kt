package com.junemon.daggerinmitch.feature.main.di

import androidx.lifecycle.ViewModel
import com.junemon.daggerinmitch.di.factory.ViewModelKey
import com.junemon.daggerinmitch.feature.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel):ViewModel

}