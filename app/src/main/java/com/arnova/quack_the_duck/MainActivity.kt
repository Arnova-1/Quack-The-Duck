package com.arnova.quack_the_duck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arnova.quack_the_duck.ui.theme.QuackTheDuckTheme
import com.arnova.quack_the_duck.ui.screen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuackTheDuckTheme {
                    MainScreen()
                }
            }
        }
    }