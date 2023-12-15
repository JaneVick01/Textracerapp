package com.example.textracerapp.navigation

sealed class Screens(val route: String) {
    object Home : Screens("Home")
    object Login : Screens("Login")
    object Register : Screens("Register")
    object Account : Screens("Account")
}