package com.example.shoppingapp.productDetails.presenter

import com.example.shoppingapp.CoroutinesTestRule
import com.example.shoppingapp.model.ModelContract
import com.example.shoppingapp.model.Products
import com.example.shoppingapp.productDetails.ProductDetailsContract
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.KArgumentCaptor
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class ProductDetailsPresenterTest {
    @get: Rule
    val coroutineTestRule = CoroutinesTestRule()

    @Mock
    lateinit var view: ProductDetailsContract.View

    @Mock
    lateinit var model: ModelContract

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `Check if presenter call the view to show product details information as favorite`() {
        val product: Products = Products(3, "Pants", 12.00, "Pants for man", "Clothes", "http://")
        runBlocking {
            whenever(view.getProductSelected()).thenReturn(product.id)
            whenever(model.checkIsFavorite(view.getProductSelected())).thenReturn(true)

            ProductDetailsPresenter(view, model)

            verify(view).setProductDetailsContent()
            verify(view).showProductAsFavorite()
        }
    }

    @Test
    fun `Check if presenter call the view to show product details information as no favorite`() {
        val product: Products = Products(3, "Pants", 12.00, "Pants for man", "Clothes", "http://")
        runBlocking {
            whenever(view.getProductSelected()).thenReturn(product.id)
            whenever(model.checkIsFavorite(view.getProductSelected())).thenReturn(false)

            ProductDetailsPresenter(view, model)

            verify(view).setProductDetailsContent()
            verify(view).hideProductAsFavorite()
        }
    }

    @Test
    fun `Check if presenter is responding when the onImageButtonPressed is being called on the View`() {
        val product: Products = Products(3, "Pants", 12.00, "Pants for man", "Clothes", "http://")
        runBlocking {
            whenever(view.getProductSelected()).thenReturn(product.id)
            whenever(model.checkIsFavorite(view.getProductSelected())).thenReturn(false)

            ProductDetailsPresenter(view, model)

            val argumentCaptor: KArgumentCaptor<(Products) -> Unit> = argumentCaptor()
            verify(view).onFavoriteImageViewPressed(argumentCaptor.capture())
            argumentCaptor.firstValue.invoke(product)
            verify(model).saveFavorite(product)
            verify(view).showProductAsFavorite()
        }
    }
}