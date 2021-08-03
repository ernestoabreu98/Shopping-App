package com.example.shoppingapp.model

import com.example.shoppingapp.repositories.APIService
import com.example.shoppingapp.repositories.FavoritesProducts
import com.example.shoppingapp.repositories.FavoritesProductsDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShoppingAppModel(private val dao: FavoritesProductsDAO) : ModelContract {


    private val client = APIService()

    override fun getAllFavorites(): List<FavoritesProducts> {
        return dao.getAllFavorites()
    }

    override suspend fun getAllProducts(): List<Products> {
        return withContext(Dispatchers.IO) {
            client.getAllProducts()
        }
    }
}