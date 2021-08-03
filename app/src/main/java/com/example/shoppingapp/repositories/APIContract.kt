package com.example.shoppingapp.repositories

import com.example.shoppingapp.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface APIContract {
    @GET("products")
    suspend fun fetchAllProducts(): Response<List<Products>>
}