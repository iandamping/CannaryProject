package com.junemon.daggerinmitch.di.module

import com.junemon.daggerinmitch.feature.SplashActivity
import com.junemon.daggerinmitch.feature.main.di.MainActivityModule
import com.junemon.daggerinmitch.feature.main.di.MainViewModelModule
import com.junemon.daggerinmitch.feature.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    /*this is potential client in the future
    *
    * and SplashViewModelModule is a subcomponent from this module and can only be used in splash activity*/
    @ContributesAndroidInjector()
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(
        modules = [MainViewModelModule::class,
            MainActivityModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}