package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {
    @GET("api/users")
    fun getUserList(@Query("page")page: Int): Call<UserListModel>
}

object UserRetrofitService {
    val retrofit = Retrofit.Builder().baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create()).build()

}