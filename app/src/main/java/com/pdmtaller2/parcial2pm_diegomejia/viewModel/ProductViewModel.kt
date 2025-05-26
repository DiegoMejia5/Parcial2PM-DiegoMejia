package com.pdmtaller2.parcial2pm_diegomejia.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pdmtaller2.parcial2pm_diegomejia.models.Product
import com.pdmtaller2.parcial2pm_diegomejia.models.productList

class ProductViewModel : ViewModel() {
    var products = productList
    var searchQuery by mutableStateOf("")
    var selectedProduct: Product? by mutableStateOf(null)
    private val _cartItems = mutableStateListOf<Product>()
    val cartItems: List<Product> get() = _cartItems

    val filteredProducts: List<Product>
        get() = if (searchQuery.isBlank()) {
            products
        } else {
            products.filter {
                it.name.contains(searchQuery, ignoreCase = true) ||
                        it.category.contains(searchQuery, ignoreCase = true)
            }
        }

    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    fun selectProduct(product: Product) {
        selectedProduct = product
    }

    fun addToCart(product: Product) {
        if (!_cartItems.contains(product)) {
            _cartItems.add(product)
        }
    }
}
