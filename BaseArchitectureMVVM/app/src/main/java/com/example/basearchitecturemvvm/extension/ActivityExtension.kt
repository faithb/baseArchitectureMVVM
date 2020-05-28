@file:Suppress("DEPRECATION")

package com.example.basearchitecturemvvm.extension

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.basearchitecturemvvm.ui.base.BaseVMFactory

/**
 * Created by HungTran.V on 2020-05-27.
 */

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null) {
        ViewModelProviders.of(this)[T::class.java]
    } else {
        ViewModelProviders.of(this, BaseVMFactory(creator))[T::class.java]
    }
}
