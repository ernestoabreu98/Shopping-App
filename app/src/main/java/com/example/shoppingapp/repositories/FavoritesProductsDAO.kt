package com.example.shoppingapp.repositories

import androidx.room.*

@Dao
interface FavoritesProductsDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun saveFavorite(product: FavoritesProducts)

    @Delete
    fun deleteFavorite(product: FavoritesProducts)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): List<FavoritesProducts>
}