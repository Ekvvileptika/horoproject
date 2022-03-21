package com.ekvileptika.horoproject.presentation.mainpage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainPageScreen(
    viewModel: MainPageViewModel = hiltViewModel()
) {
    val displayData = viewModel.horoState.value
    if(displayData.description != ""){
        Column{
            Text(
                text = displayData.description,
                color = Color.White
            )
            Text(text = displayData.color)
            Text(text = displayData.date_range)
        }
    }
}