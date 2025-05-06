package com.arnova.quacktheduck.ui.customer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arnova.quacktheduck.R

@Composable
fun ServeButton(
    modifier: Modifier = Modifier,
    onOrderTaken: () -> Unit
) {
    Button (
        onClick = { onOrderTaken() },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFEE8C)),
        shape = CircleShape,
        contentPadding = PaddingValues(10.dp),
    ) {
        Icon(
            painter = painterResource(R.drawable.cook_icon),
            contentDescription = "Serve Icon",
            modifier = Modifier.size(110.dp),
            tint = Color.Unspecified
        )
    }
}