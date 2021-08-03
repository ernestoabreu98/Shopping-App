package com.example.shoppingapp.productsList.presenter

import com.example.shoppingapp.model.ModelContract
import com.example.shoppingapp.productsList.ProductListContract
import com.example.shoppingapp.productsList.view.ProductsListView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductListPresenter(private val view: ProductsListView, private val model: ModelContract) :
    ProductListContract.Presenter {

    init {
        CoroutineScope(Dispatchers.Main).launch {
            view.showProductList(model.getAllProducts())
        }
    }
}