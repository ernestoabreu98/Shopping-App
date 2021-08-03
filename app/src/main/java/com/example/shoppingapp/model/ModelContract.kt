package com.example.shoppingapp.model

interface ModelContract {
    suspend fun getAllProducts(): List<Products>
}