package com.example.shoppingapp.productsList.recyclerView

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.R
import com.example.shoppingapp.model.Products
import com.example.shoppingapp.productDetails.ProductDetailsActivity

class ProductsAdapter(private val products: List<Products>) :
    RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsViewHolder(layoutInflater.inflate(R.layout.product_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val itemTitle = products[position].title
        val itemImage = products[position].image
        holder.bind(itemTitle, itemImage)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ProductDetailsActivity::class.java).apply {
                putExtra(R.id.product.toString(), products[position])
            }

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = products.size
}