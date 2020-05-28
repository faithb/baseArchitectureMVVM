package com.example.basearchitecturemvvm.ui

import android.os.Bundle
import android.util.Log
import com.example.basearchitecturemvvm.R
import com.example.basearchitecturemvvm.data.service.ApiClient
import com.example.basearchitecturemvvm.model.User
import com.example.basearchitecturemvvm.ui.base.BaseActivity
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
