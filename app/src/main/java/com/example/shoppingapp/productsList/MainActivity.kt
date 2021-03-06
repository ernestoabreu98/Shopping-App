package com.example.shoppingapp.productsList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.model.ShoppingAppModel
import com.example.shoppingapp.productsList.presenter.ProductListPresenter
import com.example.shoppingapp.productsList.view.ProductsListView
import com.example.shoppingapp.repositories.ShoppingAppDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProductListPresenter(
            ProductsListView(this),
            ShoppingAppModel(
                ShoppingAppDatabase.getDb(this).favoritesProductsDAO()
            )
        )
    }
}