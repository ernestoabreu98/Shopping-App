package com.example.shoppingapp.repositories

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoritesProducts(
    @PrimaryKey val id: Int,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val image: String,
    val isFavorite: Boolean
)