package com.junemon.daggerinmitch.di.module

import com.junemon.daggerinmitch.feature.SplashActivity
import com.junemon.daggerinmitch.feature.main.di.MainActivityModule
import com.junemon.daggerinmitch.feature.main.di.MainActivityViewModelModule
import com.junemon.daggerinmitch.feature.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    /*this is potential client in the future
    *
    * every module that define in ContributesAndroidInjector is a subcomponent where this
    * module is used, which is in AppComponent*/
    @ContributesAndroidInjector()
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(
        modules = [MainActivityViewModelModule::class,
            MainActivityModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}