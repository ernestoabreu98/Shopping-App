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

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun showProductList(data: List<Products>) {
        binding.progressBar.setTransitionVisibility(View.GONE)
        adapter = ProductsAdapter(data)
        binding.productsRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        binding.productsRecyclerView.adapter = adapter
    }
}