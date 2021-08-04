package com.example.shoppingapp.repositories

import android.util.Log
import com.example.shoppingapp.model.Products
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


class APIService {
    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

    private fun getRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    suspend fun getAllProducts(): List<Products> {
        var data = emptyList<Products>()
        val response = getRetrofit().create(APIContract::class.java).fetchAllProducts()
        if (response.isSuccessful) {
            response.body()?.let {
                data = it
            }
        } else {
            Log.e("Fetch Error", "Something Went Wrong")
        }
        return data
    }
}