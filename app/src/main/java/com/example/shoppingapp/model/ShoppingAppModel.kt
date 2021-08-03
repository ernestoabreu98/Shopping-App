package com.example.shoppingapp.model

import com.example.shoppingapp.repositories.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShoppingAppModel : ModelContract {

    private val client = APIService()

    override suspend fun getAllProducts(): List<Products> {
        return withContext(Dispatchers.IO) {
            client.getAllProducts()
        }
    }
}