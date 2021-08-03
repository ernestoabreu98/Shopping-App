package com.example.shoppingapp.productDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.model.ShoppingAppModel
import com.example.shoppingapp.productDetails.presenter.ProductDetailsPresenter
import com.example.shoppingapp.productDetails.view.ProductDetailsView
import com.example.shoppingapp.repositories.FavoritesProductsDAO
import com.example.shoppingapp.repositories.ShoppingAppDatabase

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val favoritesProductsDAO: FavoritesProductsDAO = ShoppingAppDatabase.getDb(this).favoritesProductsDAO()
        ProductDetailsPresenter(ProductDetailsView(this), ShoppingAppModel(favoritesProductsDAO))
    }
}