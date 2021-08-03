package com.example.shoppingapp.productDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.R
import com.example.shoppingapp.model.ShoppingAppModel
import com.example.shoppingapp.productDetails.presenter.ProductDetailsPresenter
import com.example.shoppingapp.productDetails.view.ProductDetailsView

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var presenter: ProductDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        presenter = ProductDetailsPresenter(ProductDetailsView(this), ShoppingAppModel())
    }
}