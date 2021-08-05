package com.example.shoppingapp.productsList.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.R
import com.example.shoppingapp.model.Products
import com.example.shoppingapp.productsList.view.ProductsListView

class ProductsAdapter(
    private val products: List<Products>,
    private val onItemClickListener: ProductsListView.OnItemClickListener
) :
    RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsViewHolder(layoutInflater.inflate(R.layout.product_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = products[position]
        val itemTitle = product.title
        val itemImage = product.image
        holder.bind(itemTitle, itemImage)

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(product)
        }
    }

    override fun getItemCount(): Int = products.size
}