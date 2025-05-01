package com.arnova.quack_the_duck.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

data class FloatingPop(val id: Int, val timestamp: Long = System.currentTimeMillis())

@Composable
fun FloatingPopEffect(
    onFinished: () -> Unit,
    modifier: Modifier = Modifier
) {
    val offsetY = remember { Animatable(0f) }
    val alpha = remember { Animatable(1f) }
    val offsetX = remember { Animatable(0f) }
    val scale = remember { Animatable(0.8f) }

    val direction = remember { if(Random.nextBoolean()) 1 else -1 }
    val horizontalDrift = remember { Random.nextInt(-10,50) * direction }

    LaunchedEffect(Unit) {
        launch {
            scale.animateTo(
                targetValue = 1.2f,
                animationSpec = tween(150, easing = FastOutSlowInEasing)
            )
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(150, easing = FastOutSlowInEasing)
            )
        }
        launch {
            offsetY.animateTo(
                targetValue = -60f,
                animationSpec = tween(600, easing = FastOutSlowInEasing)
            )
        }
        launch {
            offsetX.animateTo(
                targetValue = horizontalDrift.toFloat(),
                animationSpec = tween(600, easing = LinearEasing)
            )
        }
        launch {
            delay(300)
            alpha.animateTo(
                targetValue = 0f,
                animationSpec = tween(500)
            )
        }
        delay(700)
        onFinished()
    }

    Text(
        text = "+1",
        fontSize = 20.sp,
        modifier = Modifier
            .offset(x = offsetX.value.dp + 30.dp, y = offsetY.value.dp - 55.dp)
            .alpha(alpha.value)
            .scale(scale.value)
    )
}