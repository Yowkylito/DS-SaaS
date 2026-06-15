package com.dropshipping.saas.data.api

import com.dropshipping.saas.data.models.Product
import com.dropshipping.saas.data.models.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApiService {
    @GET("/api/products")
    suspend fun getProducts(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): ProductResponse

    @GET("/api/products/{id}")
    suspend fun getProductById(@Path("id") id: String): Product

    @GET("/api/products/search")
    suspend fun searchProducts(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): ProductResponse
}