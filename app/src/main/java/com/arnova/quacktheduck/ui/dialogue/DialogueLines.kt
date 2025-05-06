package com.arnova.quacktheduck.ui.dialogue

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DialogueLines(
    modifier: Modifier = Modifier,
    onDialogueEnd: () -> Unit
) {
    val dialogueLines = listOf(
        "Good morning, sir! Are you, by any chance, new in this vicinity?",
        "Splendid! One simply cannot traverse the park on an empty stomach, you know.",
        "This is, in fact, also an excellent opportunity to broaden my culinary horizons.",
        "Ah, do forgive my extended interruption.",
        "Now then—one Onigiri, if you would be so kind."
    )

    var currentLine by remember { mutableIntStateOf(0) }

    if (currentLine < dialogueLines.size) {
        DialogueBox(
            text = dialogueLines[currentLine],
            modifier = modifier
                .padding(top = 50.dp),
            onClick = {
                if (currentLine < dialogueLines.lastIndex) {
                    currentLine++
                } else {
                    onDialogueEnd()
                }
            }
        )
    }
}