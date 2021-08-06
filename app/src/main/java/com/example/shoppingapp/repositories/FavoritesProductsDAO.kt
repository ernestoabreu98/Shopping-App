package com.example.shoppingapp.repositories

import androidx.room.*

@Dao
interface FavoritesProductsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavorite(product: FavoritesProducts)

    @Delete
    fun deleteFavorite(product: FavoritesProducts)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): List<FavoritesProducts>

    @Query("SELECT count(id) FROM favorites WHERE id = :id")
    fun isFavorite(id: Int) : Int

    @Query("SELECT * FROM favorites WHERE id = :id")
    fun getFavoriteById(id: Int): FavoritesProducts?
}