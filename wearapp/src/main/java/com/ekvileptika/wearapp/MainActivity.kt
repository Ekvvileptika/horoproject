package com.ekvileptika.wearapp

import android.app.Activity
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyListState
import androidx.wear.compose.material.rememberScalingLazyListState
import com.ekvileptika.wearapp.presentation.mainpage.MainPageScreen
import com.ekvileptika.wearapp.presentation.navigation.MainNavigation
import com.ekvileptika.wearapp.ui.component.CustomPositionIndicator
import com.ekvileptika.wearapp.ui.theme.HoroProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoroProjectTheme {
                val scrollState = rememberScalingLazyListState()
                Scaffold(
                    pageIndicator = {
                        CustomPositionIndicator(
                            visible = scrollState.isScrollInProgress,
                            scallingLazy = scrollState
                        )
                    }
                ) {
                    StarterScreen(scrollState = scrollState)
                }
            }
        }
    }
}


@Composable
fun StarterScreen(
    scrollState: ScalingLazyListState
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        MainNavigation(scrollState = scrollState)
    }
}