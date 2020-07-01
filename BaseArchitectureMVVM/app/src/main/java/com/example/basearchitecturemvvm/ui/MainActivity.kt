package com.example.basearchitecturemvvm.ui

import android.os.Bundle
import com.example.basearchitecturemvvm.R
import com.example.basearchitecturemvvm.extension.addFragment
import com.example.basearchitecturemvvm.ui.base.BaseActivity
import com.example.basearchitecturemvvm.ui.detail.FruitDetailFragment
import com.example.basearchitecturemvvm.ui.home.HomeFragment
import com.example.basearchitecturemvvm.ui.login.LoginFragment
import com.example.basearchitecturemvvm.ui.statistics.FruitClassFicationFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openLoginFragment()
    }

    private fun openLoginFragment() {
        addFragment(R.id.frContainer, LoginFragment.newInstance(), addToBackStack = true)
    }

    internal fun openHomeFragment() {
        addFragment(R.id.frContainer, HomeFragment.newInstance(), addToBackStack = true)
    }

    internal fun openFruitDetailFragment() {
        addFragment(R.id.frContainer, FruitDetailFragment.newInstance(), addToBackStack = true)
    }

    internal fun openFruitClassFicationFragment() {
        addFragment(R.id.frContainer, FruitClassFicationFragment.newInstance(), addToBackStack = true)
    }
}
