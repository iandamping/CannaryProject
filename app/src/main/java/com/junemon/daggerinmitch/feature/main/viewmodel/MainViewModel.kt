package com.junemon.daggerinmitch.feature.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.junemon.daggerin.model.GamesEntity
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerinmitch.base.BaseViewModel
import com.junemon.daggerinmitch.base.ResultToConsume
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val api:ApiInterface): BaseViewModel() {
    private val TAG = "SplashViewModel"
    private val _observeGame:MutableLiveData<ResultToConsume<List<GamesEntity>>> = MutableLiveData()

    val observeGame :LiveData<ResultToConsume<List<GamesEntity>>>
    get() = _observeGame

    fun getData() {
        try {
            requireNotNull(api){
                "api interface is null or not initialized yet"
            }
            compositeDisposable.add(
                api.getGames().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        _observeGame.postValue(ResultToConsume.loading())
                    }
                    .subscribe({
                        _observeGame.postValue(ResultToConsume.success(it.data))
                    }, {
                        _observeGame.postValue(error(it.message!!))
                    })
            )
        }catch (e:Exception){
            timberLogE(e.message)
        }
    }
}