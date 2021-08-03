package com.example.shoppingapp.productDetails.view

import android.app.Activity
import com.example.shoppingapp.databinding.ActivityProductDetailsBinding
import com.example.shoppingapp.productDetails.ProductDetailsContract

class ProductDetailsView(private val activity: Activity) : ProductDetailsContract.View {

    private val binding = ActivityProductDetailsBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }
}