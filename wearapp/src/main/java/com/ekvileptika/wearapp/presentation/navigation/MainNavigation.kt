package com.ekvileptika.wearapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.ScalingLazyListState
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.ekvileptika.wearapp.presentation.info.InfoScreen
import com.ekvileptika.wearapp.presentation.list.ListScreen

@Composable
fun MainNavigation(
    scrollState: ScalingLazyListState
) {
    val navConttroller = rememberSwipeDismissableNavController()

    SwipeDismissableNavHost(
        navController = navConttroller,
        startDestination = MainRoutes.MainPage.route
    ){
        composable(MainRoutes.MainPage.route){
            ListScreen(
                navController = navConttroller,
                scrollState = scrollState
            )
        }

        composable("${MainRoutes.InfoPage.route}/{sign}"){ bckstk ->
            InfoScreen(sign = bckstk.arguments?.getString("sign") ?: "")
        }
    }
}