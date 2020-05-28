package com.example.basearchitecturemvvm.data.source.remote

import com.example.basearchitecturemvvm.data.response.ApiSuccessResponse
import com.example.basearchitecturemvvm.data.service.ApiClient
import com.example.basearchitecturemvvm.data.service.ApiService
import com.example.basearchitecturemvvm.data.source.request.TaskDataSource
import com.example.basearchitecturemvvm.model.User
import io.reactivex.Single

/**
 * Created by HungTran.V on 2020-05-27.
 */
class TaskRemoteDataSource : TaskDataSource {
    private val service: ApiService = ApiClient.getInstance().getService

    override fun getPhoto(): Single<ApiSuccessResponse<MutableList<User>>> = service.getPhotos()
}
