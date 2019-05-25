package com.sstudio.apiretrofit2rxjava2mvp.presenter

import com.sstudio.apiretrofit2rxjava2mvp.contract.ApiRepositoryContract
import com.sstudio.apiretrofit2rxjava2mvp.models.Profile
import com.sstudio.apiretrofit2rxjava2mvp.rests.ApiRepository
import io.reactivex.Flowable

class ApiRepositoryImpl(private val apiRepository: ApiRepository): ApiRepositoryContract {
    override fun getProfile(): Flowable<List<Profile>> = apiRepository.getProfile()

}