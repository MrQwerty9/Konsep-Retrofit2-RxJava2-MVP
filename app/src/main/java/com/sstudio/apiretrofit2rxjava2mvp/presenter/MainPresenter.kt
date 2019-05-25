package com.sstudio.apiretrofit2rxjava2mvp.presenter

import android.util.Log
import com.sstudio.apiretrofit2rxjava2mvp.contract.MainContract
import com.sstudio.apiretrofit2rxjava2mvp.models.Profile
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class MainPresenter(private val view: MainContract.View, private val apiRepositoryImpl: ApiRepositoryImpl): MainContract.Presenter {

    private val composidDisposable = CompositeDisposable()

    override fun getProfile() {
        view.showLoading()
        composidDisposable.add(apiRepositoryImpl.getProfile()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<List<Profile>>(){
                override fun onComplete() {
                    view.hideLoading()
                }

                override fun onNext(t: List<Profile>?) {
                    view.listProfile(t!!)
                    Log.i("MainPresenter", "t $t")
                }

                override fun onError(t: Throwable?) {
                    view.hideLoading()
                    view.listProfile(Collections.emptyList())
                }

            }))
    }

    override fun destroyFetch() {
        composidDisposable.dispose()
    }


}