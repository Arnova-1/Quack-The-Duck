package com.arnova.quacktheduck.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arnova.quacktheduck.ui.layout.CustomerWindow
import com.arnova.quacktheduck.ui.layout.HUD
import com.arnova.quacktheduck.ui.layout.KitchenView

enum class GameScreen {
    Window,
    Kitchen
}

@Preview
@Composable
fun GameScreen(modifier: Modifier = Modifier){
    var currentScreen by remember { mutableStateOf(GameScreen.Window) }

    Scaffold { innerPadding ->
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            when(currentScreen) {
                GameScreen.Window -> CustomerWindow(
                    onOrderTaken = {currentScreen = GameScreen.Kitchen}
                )
                GameScreen.Kitchen -> KitchenView()
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                HUD()
            }
        }
    }
}