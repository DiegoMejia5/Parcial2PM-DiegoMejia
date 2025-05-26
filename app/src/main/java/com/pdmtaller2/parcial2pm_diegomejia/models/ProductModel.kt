package com.pdmtaller2.parcial2pm_diegomejia.models

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val description: String,
    val image: String,
    var addedToCart: Boolean = false
)
