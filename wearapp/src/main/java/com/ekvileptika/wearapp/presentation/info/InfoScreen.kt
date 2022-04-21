package com.ekvileptika.wearapp.presentation.info

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.Text
import com.ekvileptika.wearapp.utils.Resource

@Composable
fun InfoScreen(
    sign: String,
    viewModel: InfoScreenViewModel = hiltViewModel()
) {
    val displayData = viewModel.horoState.value

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        when(displayData){
            is Resource.Loading -> {
                viewModel.getHoroscopeInformation(sign)

                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is Resource.Success -> {
                Text(
                    text = displayData.data?.description ?: "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(
                            horizontal = 20.dp,
                            vertical = 20.dp
                        ),
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 18.sp
                    )
                )
            }

            is Resource.Error -> {
                Text(text = displayData.message ?: "No data to display")
            }
        }
    }
}