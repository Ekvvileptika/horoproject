package com.ekvileptika.wearapp.presentation.navigation

sealed class MainRoutes(
    val route: String
){
    object MainPage: MainRoutes("mainpage")
    object InfoPage: MainRoutes("infopage")
}