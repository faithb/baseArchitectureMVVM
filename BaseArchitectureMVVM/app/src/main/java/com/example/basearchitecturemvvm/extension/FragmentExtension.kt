@file:Suppress("DEPRECATION")

package com.example.basearchitecturemvvm.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.basearchitecturemvvm.ui.base.BaseVMFactory

/**
 * Created by HungTran.V on 2020-05-27.
 */

inline fun <reified T : ViewModel> Fragment.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null) {
        ViewModelProviders.of(this)[T::class.java]
    } else {
        ViewModelProviders.of(this, BaseVMFactory(creator))[T::class.java]
    }
}

internal fun TextView.afterTextChanged(afterTextChanged: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}

