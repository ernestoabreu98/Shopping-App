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

    lateinit var presenter: ProductListContract.Presenter
    lateinit var favoritesProductsDAO: FavoritesProductsDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesProductsDAO = ShoppingAppDatabase.getDb(this).favoritesProductsDAO()
        presenter = ProductListPresenter(ProductsListView(this), ShoppingAppModel(favoritesProductsDAO))
    }
}