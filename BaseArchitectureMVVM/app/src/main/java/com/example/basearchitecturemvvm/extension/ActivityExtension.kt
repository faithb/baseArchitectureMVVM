@file:Suppress("DEPRECATION")

package com.example.basearchitecturemvvm.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
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

internal fun FragmentActivity.addFragment(
    containerId: Int,
    fragment: Fragment,
    transactionCallback: ((transaction: FragmentTransaction) -> Unit)? = null,
    addToBackStack: Boolean = false,
    tag: String? = null
) {
    val transaction = supportFragmentManager.beginTransaction()
    transactionCallback?.invoke(transaction)
    transaction.add(containerId, fragment, tag ?: fragment.javaClass.simpleName)
    if (addToBackStack) {
        transaction.addToBackStack(tag ?: fragment.javaClass.simpleName)
    }
    transaction.commit()
}