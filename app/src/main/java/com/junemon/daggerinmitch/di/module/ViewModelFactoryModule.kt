package com.junemon.daggerinmitch.di.module

import androidx.lifecycle.ViewModelProvider
import com.junemon.daggerinmitch.di.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory:ViewModelProviderFactory):ViewModelProvider.Factory

}