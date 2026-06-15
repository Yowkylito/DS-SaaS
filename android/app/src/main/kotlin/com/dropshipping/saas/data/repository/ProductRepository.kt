package com.dropshipping.saas.data.repository

import com.dropshipping.saas.data.api.ProductApiService
import com.dropshipping.saas.data.models.Product

class ProductRepository(
    private val apiService: ProductApiService
) {
    suspend fun getProducts(page: Int = 1, limit: Int = 20): List<Product> {
        return try {
            val response = apiService.getProducts(page, limit)
            response.products
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getProductById(id: String): Product? {
        return try {
            apiService.getProductById(id)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun searchProducts(query: String, page: Int = 1): List<Product> {
        return try {
            val response = apiService.searchProducts(query, page)
            response.products
        } catch (e: Exception) {
            emptyList()
        }
    }
}