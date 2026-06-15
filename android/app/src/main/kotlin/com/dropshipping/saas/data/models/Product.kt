package com.dropshipping.saas.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    val imageUrl: String,
    val rating: Double,
    val reviewCount: Int,
    val inStock: Boolean
)

@Serializable
data class ProductResponse(
    val products: List<Product>,
    val total: Int,
    val page: Int
)