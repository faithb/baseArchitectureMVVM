package com.example.basearchitecturemvvm.data.service

import com.example.basearchitecturemvvm.data.response.ApiSuccessResponse
import com.example.basearchitecturemvvm.model.User
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Copyright © 2020 SupremeTech inc.
 * Created by HungTran.V on 2020-05-26.
 */
interface ApiService {
    // TODO dummy, it will delete later
    @GET("api/v1/employees")
    fun getPhotos(): Single<ApiSuccessResponse<MutableList<User>>>
}
