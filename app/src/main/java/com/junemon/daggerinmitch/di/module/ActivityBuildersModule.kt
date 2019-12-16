package com.junemon.daggerinmitch.di.module

import com.junemon.daggerinmitch.view.SplashActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBuildersModule {

    /*this is potential client in the future*/
    @ContributesAndroidInjector
    abstract fun contributeSplashActivity():SplashActivity

}