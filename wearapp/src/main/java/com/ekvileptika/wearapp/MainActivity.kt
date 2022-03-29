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
import com.ekvileptika.wearapp.presentation.mainpage.MainPageScreen
import com.ekvileptika.wearapp.ui.theme.HoroProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HoroProjectTheme {
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {*/
                    Greeting("Android")
                //}
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        /*Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Hello $name!"
        )*/

        MainPageScreen()
    }
}