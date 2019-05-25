package com.sstudio.apiretrofit2rxjava2mvp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sstudio.apiretrofit2rxjava2mvp.R
import com.sstudio.apiretrofit2rxjava2mvp.contract.MainContract
import com.sstudio.apiretrofit2rxjava2mvp.models.Profile
import com.sstudio.apiretrofit2rxjava2mvp.presenter.ApiRepositoryImpl
import com.sstudio.apiretrofit2rxjava2mvp.presenter.MainPresenter
import com.sstudio.apiretrofit2rxjava2mvp.rests.ApiService

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doRequest()
    }

    private fun doRequest(){
        presenter = MainPresenter(this, ApiRepositoryImpl(ApiService.create()))
        presenter.getProfile()
    }

    override fun showLoading() {

    }

    override fun listProfile(t: List<Profile>) {
        Log.i("MainActivity", "Data profile: $t")
    }

    override fun hideLoading() {

    }
}
