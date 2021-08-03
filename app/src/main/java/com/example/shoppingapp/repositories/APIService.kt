package com.example.shoppingapp.repositories

import android.util.Log
import com.example.shoppingapp.model.Products
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class APIService {
    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    suspend fun getAllProducts(): List<Products> {
        var data = emptyList<Products>()
        val response = getRetrofit().create(APIContract::class.java).fetchAllProducts()
        if (response.isSuccessful) {
            data = response.body()!!
        } else {
            Log.e("Fetch Error", "Something Went Wrong")
        }
        return data
    }
}