package com.arnova.quack_the_duck.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import com.arnova.quack_the_duck.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ServeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(Modifier.size(120.dp)) {
        var pressed by remember { mutableStateOf(false) }

        val scale by animateFloatAsState(
            targetValue = if (pressed) 0.8f else 1f,
            animationSpec = tween(100),
            label = "scaleAnim"
        )

        val coroutineScope = rememberCoroutineScope()

        Button(
            onClick = {
                pressed = true

                onClick()
                coroutineScope.launch {
                    delay(100)
                    pressed = false
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFEE8C)),
            shape = CircleShape,
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.cook_icon),
                    contentDescription = "Serve Duck",
                    modifier = Modifier.size(110.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}