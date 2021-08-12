package com.example.shoppingapp.productDetails

import com.example.shoppingapp.model.Products

interface ProductDetailsContract {
    interface Presenter

    interface View {
        fun setProductDetailsContent()
        fun onFavoriteImageViewPressed(onClick: (product: Products) -> Unit)
        fun getProductSelected(): Int
        fun showProductAsFavorite()
        fun hideProductAsFavorite()
    }
}