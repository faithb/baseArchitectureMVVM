package com.example.basearchitecturemvvm.data.response

import com.google.gson.annotations.SerializedName

/**
 * Created by HungTran.V on 2020-05-27.
 */

data class WordPressApiErrorMessage(
    @SerializedName("message") val errorMessage: String? = null
) : Throwable()
