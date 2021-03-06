package com.example.shoppingapp.model

import com.example.shoppingapp.repositories.APIService
import com.example.shoppingapp.repositories.FavoritesProducts
import com.example.shoppingapp.repositories.FavoritesProductsDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShoppingAppModel(
    private val dao: FavoritesProductsDAO,
) : ModelContract {

    private val client = APIService()

    override fun getAllFavorites(): List<FavoritesProducts> {
        return dao.getAllFavorites()
    }

    override suspend fun checkIsFavorite(id: Int): Boolean {
        return withContext(Dispatchers.IO) {
            dao.isFavorite(id) > 0
        }
    }

    override suspend fun saveFavorite(product: Products) {
        withContext(Dispatchers.IO) {
            dao.saveFavorite(
                FavoritesProducts(
                    product.id,
                    product.title,
                    product.category,
                    product.description,
                    product.price,
                    product.image,
                    true
                )
            )
        }
    }

    override suspend fun deleteFavorite(productId: Int) {
        withContext(Dispatchers.IO) {
            val productToDelete = dao.getFavoriteById(productId)
            productToDelete?.let { dao.deleteFavorite(it) }
        }
    }

    override suspend fun getAllProducts(): List<Products> {
        return withContext(Dispatchers.IO) {
            client.getAllProducts()
        }
    }
}
