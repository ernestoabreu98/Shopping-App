package com.example.shoppingapp.repositories

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorites")
data class FavoritesProducts(@PrimaryKey val id: Int)