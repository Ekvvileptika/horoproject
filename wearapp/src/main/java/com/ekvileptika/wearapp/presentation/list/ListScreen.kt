package com.ekvileptika.wearapp.presentation.list

import android.app.LauncherActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.ScalingLazyListState
import androidx.wear.compose.material.Text
import com.ekvileptika.wearapp.presentation.mainpage.HoroscopeSignModel
import com.ekvileptika.wearapp.presentation.mainpage.SignData
import com.ekvileptika.wearapp.presentation.navigation.MainRoutes

@Composable
fun ListScreen(
    navController: NavController,
    scrollState: ScalingLazyListState
) {
    ScalingLazyColumn(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        state = scrollState,
        modifier = Modifier.fillMaxSize()
    ){
        items(count = SignData.signList.size){
            ListItem(
                signItem = SignData.signList[it]
            ){ selectedSign ->
                //go to info page
                navController.navigate(
                    "${MainRoutes.InfoPage.route}/${selectedSign.title}"
                )
            }
        }
    }
}

@Composable
fun ListItem(
    signItem: HoroscopeSignModel,
    onSelectedSign: (HoroscopeSignModel) -> Unit
) {
    Card(
        onClick = { onSelectedSign(signItem) },
        shape = RoundedCornerShape(50.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ){

            Image(
                painterResource(id = signItem.image),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .padding(end = 10.dp)
            )

            Text(
                text = signItem.title,
                modifier = Modifier.align(Alignment.CenterVertically),
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }
    }
}