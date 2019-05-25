package com.sstudio.apiretrofit2rxjava2mvp.rests

import com.sstudio.apiretrofit2rxjava2mvp.models.Profile
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiRepository {
    @GET("users")
    fun getProfile(): Flowable<List<Profile>>
}