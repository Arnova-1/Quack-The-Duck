package com.arnova.quacktheduck.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arnova.quacktheduck.R
import com.arnova.quacktheduck.ui.dialogue.DialogueLines
import com.arnova.quacktheduck.ui.customer.CustomerCard
import com.arnova.quacktheduck.ui.customer.ServeButton

@Composable
fun CustomerWindow(onOrderTaken: () -> Unit) {
    var isDialogueFinished by remember { mutableStateOf(false) }

    Box{
        Image(
            painter = painterResource(R.drawable.bg_outside),
            contentDescription = "Outside Background",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(R.drawable.food_truck_top),
            contentDescription = "Food Truck Roof",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        )
        CustomerCard(
            modifier = Modifier
                .align(Alignment.Center)
        )
        DialogueLines(
            modifier = Modifier
                .align(Alignment.Center),
            onDialogueEnd = { isDialogueFinished = true }
        )
        if (isDialogueFinished) {
            ServeButton(
                modifier = Modifier
                    .padding( top = 50.dp)
                    .align(Alignment.Center),
                onOrderTaken = onOrderTaken
            )
        }
        Image(
            painter = painterResource(R.drawable.food_truck_bottom),
            contentDescription = "Food Truck Counter",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}