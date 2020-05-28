package com.example.basearchitecturemvvm.ui

import android.app.Application
import com.example.basearchitecturemvvm.data.source.repository.LocalRepository

/**
 * Created by HungTran.V on 2020-05-27.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        LocalRepository.init(this)
    }
}
