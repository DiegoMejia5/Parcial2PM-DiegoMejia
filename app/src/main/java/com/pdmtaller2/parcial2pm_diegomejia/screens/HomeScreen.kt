package com.pdmtaller2.parcial2pm_diegomejia.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.parcial2pm_diegomejia.viewModel.ProductViewModel
import com.pdmtaller2.parcial2pm_diegomejia.models.Product
import com.pdmtaller2.parcial2pm_diegomejia.ui.components.ProductCard

@Composable
fun HomeScreen(navController: NavController, viewModel: ProductViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = { viewModel.updateSearchQuery(it) },
            label = { Text("Buscar producto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(viewModel.filteredProducts) { product ->
                ProductCard(product = product, onClick = {
                    viewModel.selectProduct(product)
                    navController.navigate("detail")
                })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("cart") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.ShoppingCart, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Ver Carrito")
        }
    }
}
