package com.ekvileptika.wearapp.ui.component

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.ScalingLazyListState

@Composable
fun CustomPositionIndicator(
    visible: Boolean,
    scallingLazy: ScalingLazyListState
) {
    if(visible){
        PositionIndicator(
            scalingLazyListState = scallingLazy
        )
    }
}