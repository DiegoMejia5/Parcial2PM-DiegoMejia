package com.pdmtaller2.parcial2pm_diegomejia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdmtaller2.parcial2pm_diegomejia.navigation.AppNavigation
import com.pdmtaller2.parcial2pm_diegomejia.ui.theme.Parcial2PMDiegoMejiaTheme
import com.pdmtaller2.parcial2pm_diegomejia.viewModel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2PMDiegoMejiaTheme {
                val productViewModel: ProductViewModel = viewModel()
                AppNavigation(viewModel = productViewModel)
            }
        }
    }
}
