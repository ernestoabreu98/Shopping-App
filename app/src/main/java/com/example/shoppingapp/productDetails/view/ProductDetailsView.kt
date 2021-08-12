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
    private val product: Products = activity.intent.extras?.get(R.id.product.toString()) as Products

    init {
        activity.setContentView(binding.root)
    }

    @SuppressLint("SetTextI18n")
    override fun setProductDetailsContent() {
        Picasso.get().load(product.image).into(binding.productDetailImage)
        binding.productTitle.text = product.title
        binding.productPrice.text =
            "${activity.resources.getString(R.string.productDetailsPrice)} ${product.price}"
        binding.productDescription.text = product.description
    }

    override fun onFavoriteImageViewPressed(onClick: (product: Products) -> Unit) {
        binding.favoriteImage.setOnClickListener {
            onClick.invoke(product)
        }
    }

    override fun getProductSelected(): Int {
        return product.id
    }

    override fun showProductAsFavorite() {
        binding.favoriteImage.setImageResource(R.drawable.gold_star)
    }

    override fun hideProductAsFavorite() {
        binding.favoriteImage.setImageResource(R.drawable.white_star)
    }
}