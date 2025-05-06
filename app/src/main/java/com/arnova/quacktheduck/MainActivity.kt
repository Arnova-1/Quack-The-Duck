package com.arnova.quacktheduck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arnova.quacktheduck.ui.theme.QuackTheDuckTheme
import com.arnova.quacktheduck.ui.screen.GameScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuackTheDuckTheme {
                    GameScreen()
            }
        }
    }
}

