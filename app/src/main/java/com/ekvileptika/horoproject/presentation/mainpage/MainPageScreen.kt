package com.ekvileptika.horoproject.presentation.mainpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainPageScreen(
    viewModel: MainPageViewModel = hiltViewModel()
) {
    val displayData = viewModel.horoState.value
    val pagerState = rememberPagerState()
    val signlist = viewModel.signList.value

    LaunchedEffect(pagerState){
        snapshotFlow {
            pagerState.currentPage
        }.collect { page ->
            //first implement horo sign list
            viewModel.getHoroscopeInformation(signlist[page].title)
        }
    }

    Column{
        //display horizontal slider
        Spacer(modifier = Modifier.height(20.dp))

        HorizontalPager(
            count = signlist.size,
            state = pagerState,
            modifier = Modifier.height(200.dp)
        ) { page ->
            //implement item view
            DisplaySliderItem(signlist[page])
        }

        Spacer(modifier = Modifier.height(20.dp))

        //display sign info
        if(displayData.description != ""){
            Column (
                modifier = Modifier.padding(16.dp)
            ){
                Text(
                    text = "-- ${displayData.date_range} --",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = displayData.description,
                    color = Color.White
                )
                Text(text = displayData.color)
            }
        }
    }
}

@Composable
fun DisplaySliderItem(item: HoroscopeSignModel) {
    Column {
        //sign image
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = item.title,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = TextStyle(
                fontSize = 25.sp
            )
        )
    }
}