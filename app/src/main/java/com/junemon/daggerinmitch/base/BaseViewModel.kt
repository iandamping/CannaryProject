package com.junemon.daggerinmitch.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

abstract class BaseViewModel:ViewModel() {
    protected val compositeDisposable by lazy { CompositeDisposable() }

    protected fun <T> error(message: String): ResultToConsume<T> {
        return ResultToConsume.error("Network call has failed for a following reason: $message")
    }

    protected  fun timberLogE(msg: String?) {
        Timber.tag("#### timber logger ####").e(msg)
    }

    protected  fun timberLogD(msg: String?) {
        Timber.tag("#### timber logger ####").d(msg)
    }

    protected  fun timberLogI(msg: String?) {
        Timber.tag("#### timber logger ####").i(msg)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}