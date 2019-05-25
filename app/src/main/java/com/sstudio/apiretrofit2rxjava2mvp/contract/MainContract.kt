package com.sstudio.apiretrofit2rxjava2mvp.contract

import com.sstudio.apiretrofit2rxjava2mvp.models.Profile

interface MainContract {
    interface View{
        fun showLoading()
        fun listProfile(t: List<Profile>)
        fun hideLoading()
    }

    interface Presenter{
        fun getProfile()
        fun destroyFetch()
    }
}