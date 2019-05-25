package com.sstudio.apiretrofit2rxjava2mvp.contract

import com.sstudio.apiretrofit2rxjava2mvp.models.Profile
import io.reactivex.Flowable

interface ApiRepositoryContract {

    fun getProfile(): Flowable<List<Profile>>

}