package com.example.shoppingapp.productDetails.presenter

import com.example.shoppingapp.model.ModelContract
import com.example.shoppingapp.productDetails.ProductDetailsContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDetailsPresenter(
    private val view: ProductDetailsContract.View,
    private val model: ModelContract
) :
    ProductDetailsContract.Presenter {
    init {
        view.setProductDetailsContent()
        CoroutineScope(Dispatchers.IO).launch {
            checkIsFavorite(view.getProductSelected())
        }

        view.onFavoriteImageViewPressed {
            CoroutineScope(Dispatchers.IO).launch {
                if (model.checkIsFavorite(it.id)) {
                    model.deleteFavorite(it.id)
                    withContext(Dispatchers.Main) {
                        view.setFavoriteValue(false)
                    }
                } else {
                    model.saveFavorite(it)
                    checkIsFavorite(it.id)
                }
            }
        }
    }

    private suspend fun checkIsFavorite(id: Int) {
        val isFavorite = model.checkIsFavorite(id)
        withContext(Dispatchers.Main) {
            view.setFavoriteValue(isFavorite)
        }
    }
}