package com.arnova.quacktheduck.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.arnova.quacktheduck.R

@Preview
@Composable
fun KitchenView() {
    Box{
        Image(
            painter = painterResource(R.drawable.kitchen_wall),
            contentDescription = "Kitchen Wall",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(R.drawable.kitchen_cabinet),
            contentDescription = "Kitchen Cabinet",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        )
        Image(
            painter = painterResource(R.drawable.kitchen_counter),
            contentDescription = "Kitchen Counter",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}