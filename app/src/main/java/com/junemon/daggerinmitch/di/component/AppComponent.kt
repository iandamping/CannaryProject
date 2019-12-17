package com.junemon.daggerinmitch.di.component

import android.app.Application
import com.junemon.daggerinmitch.MainApplication
import com.junemon.daggerinmitch.di.module.ActivityBuildersModule
import com.junemon.daggerinmitch.di.module.AppModule
import com.junemon.daggerinmitch.di.module.NetworkModule
import com.junemon.daggerinmitch.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*Component is service
* MainApplication is client
*
* when using DaggerApplication we must use this androidinjection module otherwise it cannot be compiled*/
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<MainApplication> {
    /*inject mainapplication in this component
    *
    * this component provide api because we injecting it with Component.Builder
    * so the other module that need an application is provided in here*/

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}