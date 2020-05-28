package com.example.basearchitecturemvvm.data.service.adapter

import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Copyright © 2020 SupremeTech inc.
 * Created by HungTran.V on 2020-05-26.
 */
class CustomCallAdapterFactory : CallAdapter.Factory() {
    private var original: RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    companion object {
        /**
         * Create instance
         */
        fun create(): CallAdapter.Factory = CustomCallAdapterFactory()
    }

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit)
            : CallAdapter<*, *>? {
        val type = if (returnType is ParameterizedType) getParameterUpperBound(0, returnType)
        else Any::class.java
        return RxCallAdapterWrapper(type, retrofit, original.get(returnType, annotations, retrofit))
    }
}