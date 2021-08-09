package com.example.shoppingapp.productsList.presenter

import com.example.shoppingapp.model.ModelContract
import com.example.shoppingapp.model.Products
import com.example.shoppingapp.productsList.ProductListContract
import com.example.shoppingapp.productsList.view.ProductsListView
import com.example.shoppingapp.repositories.FavoritesProducts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductListPresenter(private val view: ProductListContract.View, private val model: ModelContract) :
    ProductListContract.Presenter {

    init {
        CoroutineScope(Dispatchers.Main).launch {
            view.showProgressBar()
            view.showProductList(model.getAllProducts())
            view.hideProgressBar()
        }
    }
}