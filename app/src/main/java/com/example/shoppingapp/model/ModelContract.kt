package com.example.shoppingapp.model

import com.example.shoppingapp.repositories.FavoritesProducts

interface ModelContract {
    suspend fun getAllProducts(): List<Products>
    fun getAllFavorites(): List<FavoritesProducts>
}