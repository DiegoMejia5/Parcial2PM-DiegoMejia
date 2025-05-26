package com.pdmtaller2.parcial2pm_diegomejia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.pdmtaller2.parcial2pm_diegomejia.viewModel.ProductViewModel

@Composable
fun DetailScreen(navController: NavController, viewModel: ProductViewModel) {
    val product = viewModel.selectedProduct ?: return

    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberImagePainter(product.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = product.name, style = MaterialTheme.typography.headlineSmall)
        Text(text = "Categoría: ${product.category}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Precio: $${product.price}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = product.description, style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.addToCart(product)
            navController.popBackStack()
        }) {
            Text("Agregar al carrito")
        }
    }
}
