package com.arnova.quack_the_duck.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.arnova.quack_the_duck.ui.components.FloatingPop
import com.arnova.quack_the_duck.ui.components.FloatingPopEffect
import com.arnova.quack_the_duck.ui.components.ScoreDisplay
import com.arnova.quack_the_duck.ui.components.ServeButton

data class CookingTask(val name: String, val requiredClicks: Int)

@Preview
@Composable
fun MainScreen() {
    var score by remember { mutableIntStateOf(0) }
    var nextPopID by remember { mutableIntStateOf(0) }
    val popList = remember { mutableStateListOf<FloatingPop>() }

    val tasks = listOf(
        CookingTask("Chop Ingredients", 4),
        CookingTask("Cook", 6),
        CookingTask("Serve", 2)
    )

    var currentStep by remember { mutableIntStateOf(0) }
    var clickProgress by remember { mutableIntStateOf(0) }

    val task = tasks.getOrNull(currentStep)

    Scaffold() { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ScoreDisplay(score = score)

                Spacer(modifier = Modifier.height(32.dp))

                if (task != null) {
                    Text(
                        "Task: ${task.name}",
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text("Progress: $clickProgress / ${task.requiredClicks}")

                    Box {
                        ServeButton(
                            onClick = {

                                if (clickProgress + 1 >= task.requiredClicks) {
                                    currentStep++
                                    clickProgress = 0
                                } else {
                                    clickProgress++
                                }

                                if (popList.isNotEmpty() && popList.size >= 5) {
                                    popList.removeAt(0)
                                }

                                popList.add(FloatingPop(nextPopID))
                                nextPopID++
                            }
                        )

                        popList.forEach { pop ->
                            key(pop.id) {
                                FloatingPopEffect(
                                    onFinished = { popList.remove(pop) },
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                } else {
                    Text("Dish Completed!")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        currentStep = 0
                        clickProgress = 0
                        score += 10
                    }) {
                        Text("Start Next Order")
                    }
                }
            }
        }
    }
}
