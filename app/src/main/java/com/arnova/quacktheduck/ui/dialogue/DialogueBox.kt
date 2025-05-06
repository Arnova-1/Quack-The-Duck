package com.arnova.quacktheduck.ui.dialogue

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun DialogueBox(
    text : String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(Color.White, shape = RectangleShape)
            .border(2.dp, Color(0xFF1B1B1B) , shape = RectangleShape)
            .padding(12.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
        )
    }
}