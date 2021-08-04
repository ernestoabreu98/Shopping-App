package com.example.shoppingapp.productsList.view

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shoppingapp.databinding.ActivityMainBinding
import com.example.shoppingapp.model.Products
import com.example.shoppingapp.productsList.ProductListContract
import com.example.shoppingapp.productsList.recyclerView.ProductsAdapter

class ProductsListView(private val activity: Activity) : ProductListContract.View {

    private val binding = ActivityMainBinding.inflate(activity.layoutInflater)
    private lateinit var adapter: ProductsAdapter

    init {
        activity.setContentView(binding.root)
    }

    override fun showProductList(data: List<Products>) {
        adapter = ProductsAdapter(data)
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