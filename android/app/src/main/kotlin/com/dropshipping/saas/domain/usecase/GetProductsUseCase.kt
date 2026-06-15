package com.dropshipping.saas.domain.usecase

import com.dropshipping.saas.data.models.Product
import com.dropshipping.saas.data.repository.ProductRepository

class GetProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(page: Int = 1, limit: Int = 20): List<Product> {
        return productRepository.getProducts(page, limit)
    }
}

class GetProductByIdUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(id: String): Product? {
        return productRepository.getProductById(id)
    }
}

class SearchProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(query: String, page: Int = 1): List<Product> {
        return productRepository.searchProducts(query, page)
    }
}