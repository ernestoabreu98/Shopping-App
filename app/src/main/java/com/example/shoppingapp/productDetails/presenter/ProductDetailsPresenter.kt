package com.example.shoppingapp.productDetails.presenter

import com.example.shoppingapp.model.ModelContract
import com.example.shoppingapp.productDetails.ProductDetailsContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailsPresenter(
    private val view: ProductDetailsContract.View,
    private val model: ModelContract
) :
    ProductDetailsContract.Presenter {
    init {
        view.setProductDetailsContent()
        CoroutineScope(Dispatchers.Main).launch {
            if (model.checkIsFavorite(view.getProductSelected())) {
                view.showProductAsFavorite()
            } else {
                view.hideProductAsFavorite()
            }
        }

        view.onFavoriteImageViewPressed {
            CoroutineScope(Dispatchers.Main).launch {
                if (model.checkIsFavorite(it.id)) {
                    model.deleteFavorite(it.id)
                    view.hideProductAsFavorite()
                } else {
                    model.saveFavorite(it)
                    view.showProductAsFavorite()
                }
            }
        }
    }
}