package com.example.shoppingapp.model

import com.example.shoppingapp.repositories.FavoritesProducts

interface ModelContract {
    suspend fun getAllProducts(): List<Products>
    fun getAllFavorites(): List<FavoritesProducts>
    suspend fun saveFavorite(product: Products)
    suspend fun checkIsFavorite(id: Int): Boolean
    suspend fun deleteFavorite(productId: Int)
}