package com.example.shoppingapp.productsList

import com.example.shoppingapp.model.Products

interface ProductListContract {
    interface Presenter {

    }

    interface View {
        fun showProductList(data: List<Products>)
    }
}