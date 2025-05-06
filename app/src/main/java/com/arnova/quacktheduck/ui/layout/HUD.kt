package com.arnova.quacktheduck.ui.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.arnova.quacktheduck.ui.component.CoinDisplay

@Composable
fun HUD() {
    val coins by remember { mutableIntStateOf(0) }

    CoinDisplay(coins)
}