package com.example.pokeapi.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    modifier: Modifier,
    textValue: String
) {
    Text(
        modifier = modifier,
        text = textValue,
        textAlign = TextAlign.Center,
        style = TextStyle(
            color = MaterialTheme.colorScheme.primary,
            fontSize = 16.sp
        )
    )
}