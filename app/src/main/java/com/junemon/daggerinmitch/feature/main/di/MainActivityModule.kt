package com.junemon.daggerinmitch.feature.main.di

import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerinmitch.di.module.NetworkModule
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun provideApiInterface(): ApiInterface {
            return NetworkModule.provideRetrofit().create(ApiInterface::class.java)
        }
    }
}