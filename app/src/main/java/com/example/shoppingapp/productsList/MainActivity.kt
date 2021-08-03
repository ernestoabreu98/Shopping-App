package com.example.shoppingapp.productsList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.R
import com.example.shoppingapp.model.ShoppingAppModel
import com.example.shoppingapp.productsList.presenter.ProductListPresenter
import com.example.shoppingapp.productsList.view.ProductsListView

class MainActivity : AppCompatActivity() {

    lateinit var presenter: ProductListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ProductListPresenter(ProductsListView(this), ShoppingAppModel())
    }
}