package com.example.shoppingapp.productsList.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.databinding.ProductItemBinding
import com.squareup.picasso.Picasso

class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ProductItemBinding.bind(view)

    fun bind(title: String, image: String) {
        binding.productTitle.text = title
        Picasso.get().load(image).into(binding.productImage)
    }
}