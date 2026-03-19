package com.example.mainscreen.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mainscreen.Screens.ContactsScreen
import com.example.mainscreen.Screens.LoginScreen
import com.example.mainscreen.Screens.SignUpScreen
import com.example.mainscreen.Screens.WelcomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Contacts"
    ) {
        composable("contacts") {
            ContactsScreen(navController = navController)
        }
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("signup") {
            SignUpScreen(navController = navController)
        }
    }
}