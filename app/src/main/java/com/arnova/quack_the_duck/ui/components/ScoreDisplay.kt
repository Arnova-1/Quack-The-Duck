package com.arnova.quack_the_duck.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import  androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.arnova.quack_the_duck.R

@Composable
fun ScoreDisplay(score: Int) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource( id = R.drawable.coin),
            contentDescription = "Coin",
            modifier = Modifier.size(55.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = "$score",
            fontSize = 26.sp
        )
    }
}