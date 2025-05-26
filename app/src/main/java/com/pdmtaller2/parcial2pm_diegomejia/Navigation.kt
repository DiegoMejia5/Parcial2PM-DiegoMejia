package com.pdmtaller2.parcial2pm_diegomejia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.pdmtaller2.parcial2pm_diegomejia.screens.DetailScreen
import com.pdmtaller2.parcial2pm_diegomejia.screens.HomeScreen
import com.pdmtaller2.parcial2pm_diegomejia.ui.screens.CartScreen
import com.pdmtaller2.parcial2pm_diegomejia.viewModel.ProductViewModel

@Composable
fun AppNavigation(viewModel: ProductViewModel) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable("detail") {
            DetailScreen(navController = navController, viewModel = viewModel)
        }
        composable("cart") {
            CartScreen(viewModel = viewModel)
        }
    }
}
