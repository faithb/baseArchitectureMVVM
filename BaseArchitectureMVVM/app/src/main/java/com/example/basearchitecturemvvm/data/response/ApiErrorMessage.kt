package com.example.basearchitecturemvvm.data.response

import com.google.gson.annotations.SerializedName

/**
 * Created by HungTran.V on 2020-05-27.
 */
data class ApiErrorMessage(
    @SerializedName("code") val code: String? = null,
    @SerializedName("msg") val errorMessage: String? = null
) : Throwable() {
    companion object {
        internal const val NETWORK_ERROR_CODE = 700
    }

    var httpStatusCode: Int? = null
}