package com.example.shoppingapp.productDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.model.ShoppingAppModel
import com.example.shoppingapp.productDetails.presenter.ProductDetailsPresenter
import com.example.shoppingapp.productDetails.view.ProductDetailsView
import com.example.shoppingapp.repositories.FavoritesProductsDAO
import com.example.shoppingapp.repositories.ShoppingAppDatabase

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var presenter: ProductDetailsContract.Presenter
    lateinit var favoritesProductsDAO: FavoritesProductsDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritesProductsDAO = ShoppingAppDatabase.getDb(this).favoritesProductsDAO()
        presenter = ProductDetailsPresenter(ProductDetailsView(this), ShoppingAppModel(favoritesProductsDAO))
    }
}