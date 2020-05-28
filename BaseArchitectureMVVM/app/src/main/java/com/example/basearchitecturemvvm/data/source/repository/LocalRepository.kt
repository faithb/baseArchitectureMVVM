package com.example.basearchitecturemvvm.data.source.repository

import android.content.Context

/**
 * Created by HungTran.V on 2020-05-27.
 */

class LocalRepository private constructor(val context: Context) {

    companion object : SingletonHolder<LocalRepository, Context>(::LocalRepository)
}

open class SingletonHolder<out T : Any, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile
    private var instance: T? = null

    fun init(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }

    fun getInStance(): T =
        instance ?: throw NullPointerException("Please call init() at onCreate() Application")
}
