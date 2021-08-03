package com.example.shoppingapp.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoritesProducts::class], version = 1)
abstract class ShoppingAppDatabase : RoomDatabase() {
    abstract fun favoritesProductsDAO(): FavoritesProductsDAO

    companion object {
        private var DB: ShoppingAppDatabase? = null
        fun getDb(context: Context): ShoppingAppDatabase {
            if (DB == null) {
                DB = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingAppDatabase::class.java, "ShoppingAppDatabase"
                ).build()
            }
            return DB!!
        }
    }
}