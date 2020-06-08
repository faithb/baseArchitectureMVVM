package com.example.basearchitecturemvvm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by HungTran.V on 2020-05-27.
 */

data class User(
    //todo dummy data for user
    @SerializedName("id") val id: Long,
    @SerializedName("employee_name") val name: String,
    @SerializedName("employee_salary") val salary: String,
    @SerializedName("profile_image") val profile: String,
    @SerializedName("employee_age") val age: String
)
