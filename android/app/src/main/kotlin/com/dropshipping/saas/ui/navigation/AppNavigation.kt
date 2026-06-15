package com.dropshipping.saas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dropshipping.saas.ui.screens.index.IndexScreen

seal class Route(val route: String) {
    object Index : Route("index")
    object ProductList : Route("products")
    object ProductDetail : Route("product/{id}")
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Index.route
    ) {
        composable(Route.Index.route) {
            IndexScreen(navController = navController)
        }
        composable(Route.ProductList.route) {
            // ProductListScreen(navController = navController)
        }
    }
}