package com.arnova.quacktheduck.ui.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arnova.quacktheduck.R

@Composable
fun CustomerCard(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.customer1),
        contentDescription = "Customer #1",
        modifier = modifier
            .padding(top = 6.dp)
    )
}