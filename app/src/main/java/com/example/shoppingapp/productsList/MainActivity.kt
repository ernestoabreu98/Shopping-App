package com.example.shoppingapp.productsList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.R
import com.example.shoppingapp.model.ShoppingAppModel
import com.example.shoppingapp.productsList.presenter.ProductListPresenter
import com.example.shoppingapp.productsList.view.ProductsListView
import com.example.shoppingapp.repositories.FavoritesProductsDAO
import com.example.shoppingapp.repositories.ShoppingAppDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val favoritesProductsDAO: FavoritesProductsDAO = ShoppingAppDatabase.getDb(this).favoritesProductsDAO()
        ProductListPresenter(ProductsListView(this), ShoppingAppModel(favoritesProductsDAO))
    }
}