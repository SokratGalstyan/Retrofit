package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("public-api/products/{id}")
    fun getProduct(@Path("id")id: Int): Call<ProductModel>

}


object ProductRetrofitService {
    val retrofit = Retrofit.Builder().baseUrl("https://gorest.co.in/")
        .addConverterFactory(GsonConverterFactory.create()).build()

}