package com.example.basearchitecturemvvm.data.service.adapter

import com.example.basearchitecturemvvm.data.response.ApiErrorMessage
import retrofit2.CallAdapter
import retrofit2.HttpException
import retrofit2.Retrofit
import java.lang.reflect.Type
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class RxCallAdapterWrapper<R>(type: Type, retrofit: Retrofit, wrapped: CallAdapter<R, *>?) :
    BaseRxCallAdapterWrapper<R>(type, retrofit, wrapped) {

    override fun convertRetrofitExceptionToCustomException(
        throwable: Throwable,
        retrofit: Retrofit
    ): Throwable {
        if (throwable is HttpException) {
            return ApiErrorMessage().apply {
                httpStatusCode = throwable.code()
            }
        }

        // Set message error by this case of status code
        if (throwable is UnknownHostException || throwable is ConnectException || throwable is SocketTimeoutException) {
            return ApiErrorMessage().apply {
                httpStatusCode = ApiErrorMessage.NETWORK_ERROR_CODE
            }
        }
        return throwable
    }
}