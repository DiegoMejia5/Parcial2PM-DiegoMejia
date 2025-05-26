package com.pdmtaller2.parcial2pm_diegomejia.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pdmtaller2.parcial2pm_diegomejia.ui.components.ProductCard
import com.pdmtaller2.parcial2pm_diegomejia.viewModel.ProductViewModel

@Composable
fun CartScreen(viewModel: ProductViewModel) {
    val cartItems = viewModel.cartItems

    Column(modifier = Modifier.fillMaxSize()) {
        if (cartItems.isEmpty()) {
            Text(text = "El carrito está vacío.")
        } else {
            LazyColumn {
                items(cartItems) { product ->
                    ProductCard(product = product, onClick = {})
                }
            }
        }
    }
}
