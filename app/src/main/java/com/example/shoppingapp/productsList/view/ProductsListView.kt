package com.example.shoppingapp.productsList.view

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ActivityMainBinding
import com.example.shoppingapp.model.Products
import com.example.shoppingapp.productDetails.ProductDetailsActivity
import com.example.shoppingapp.productsList.ProductListContract
import com.example.shoppingapp.productsList.recyclerView.ProductsAdapter

class ProductsListView(private val activity: Activity) : ProductListContract.View {

    private val binding = ActivityMainBinding.inflate(activity.layoutInflater)
    private lateinit var adapter: ProductsAdapter

    interface OnItemClickListener {
        fun onItemClick(product: Products)
    }

    init {
        activity.setContentView(binding.root)
    }

    override fun showProductList(data: List<Products>) {
        adapter = ProductsAdapter(data, object : OnItemClickListener {
            override fun onItemClick(product: Products) {
                val intent = Intent(activity, ProductDetailsActivity::class.java).apply {
                    putExtra(R.id.product.toString(), product)
                }
                activity.startActivity(intent)
            }
        })
        binding.productsRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        binding.productsRecyclerView.adapter = adapter
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }
}