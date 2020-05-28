package com.example.basearchitecturemvvm.data.source.request

import com.example.basearchitecturemvvm.data.response.ApiSuccessResponse
import com.example.basearchitecturemvvm.model.User
import io.reactivex.Single

/**
 * Created by HungTran.V on 2020-05-27.
 */
interface TaskDataSource {

    fun getPhoto(): Single<ApiSuccessResponse<MutableList<User>>>
}
