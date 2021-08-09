package com.example.shoppingapp.productsList.presenter

import com.example.shoppingapp.CoroutinesTestRule
import com.example.shoppingapp.model.ModelContract
import com.example.shoppingapp.model.Products
import com.example.shoppingapp.productsList.ProductListContract
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class ProductListPresenterTest {
    @get: Rule
    val coroutineTestRule = CoroutinesTestRule()

    @Mock
    lateinit var model: ModelContract

    @Mock
    lateinit var view: ProductListContract.View

    private val productList =
        listOf(Products(1, "Name", 00.00, "Description", "Category", "http://"))

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `Check if presenter call the Model to fetch the Products List from server and call the View to Display that List`() {
        runBlocking {
            whenever(model.getAllProducts()).thenReturn(productList)

            ProductListPresenter(view, model)

            verify(view).showProgressBar()
            verify(view).showProductList(productList)
            verify(view).hideProgressBar()
        }
    }
}