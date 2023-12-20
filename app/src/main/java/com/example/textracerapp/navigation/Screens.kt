package com.example.textracerapp.navigation

sealed class Screens(val route: String) {
    object Home : Screens("Home")
    object Login : Screens("Login")
    object Task : Screens("Task")

    object Register : Screens("Register")
    object Account : Screens("Account")
}