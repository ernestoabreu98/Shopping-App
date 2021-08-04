package com.example.shoppingapp.productDetails.view

import android.annotation.SuppressLint
import android.app.Activity
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivityProductDetailsBinding
import com.example.shoppingapp.model.Products
import com.example.shoppingapp.productDetails.ProductDetailsContract
import com.squareup.picasso.Picasso

class ProductDetailsView(private val activity: Activity) : ProductDetailsContract.View {

    private val binding = ActivityProductDetailsBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }

    @SuppressLint("SetTextI18n")
    override fun setProductDetailsContent() {
        val product: Products = activity.intent.extras?.get(R.id.product.toString()) as Products
        Picasso.get().load(product.image).into(binding.productDetailImage)
        binding.productTitle.text = product.title
        binding.productPrice.text = "Price: ${product.price}"
        binding.productDescription.text = product.description
    }
}