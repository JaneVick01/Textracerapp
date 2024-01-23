package com.example.textracerapp.navigation

sealed class Screens(val route: String) {
    object Home : Screens("Home")
    object Login : Screens("Login")
    object Task : Screens("Task")
    object Register : Screens("Register")
    object Account : Screens("Account")
    object OrderEvidence : Screens("order_evidence")
    object UploadEvidence : Screens("upload_evidence")
    object Gallery : Screens("gallery")


//    data class Category(val categoryId: Int, val categoryName: String) : Screens("category/{categoryId}/{categoryName}") {
//        companion object {
//            val route: String = "category/{categoryId}/{categoryName}"
//        }
//    }
}