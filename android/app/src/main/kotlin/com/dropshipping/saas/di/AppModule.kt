package com.dropshipping.saas.di

import com.dropshipping.saas.data.api.ProductApiService
import com.dropshipping.saas.data.repository.ProductRepository
import com.dropshipping.saas.domain.usecase.GetProductByIdUseCase
import com.dropshipping.saas.domain.usecase.GetProductsUseCase
import com.dropshipping.saas.domain.usecase.SearchProductsUseCase
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://api.dropshipping.com"

private val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    single<ProductApiService> {
        get<Retrofit>().create(ProductApiService::class.java)
    }
}

private val repositoryModule = module {
    single {
        ProductRepository(get())
    }
}

private val useCaseModule = module {
    single {
        GetProductsUseCase(get())
    }
    single {
        GetProductByIdUseCase(get())
    }
    single {
        SearchProductsUseCase(get())
    }
}

val appModule = module {
    includes(
        networkModule,
        repositoryModule,
        useCaseModule
    )
}