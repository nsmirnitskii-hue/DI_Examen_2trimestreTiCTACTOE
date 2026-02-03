package com.example.tictactoe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryScreen(state: GameState) {
    LazyColumn(
        Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        items(state.history){ game ->
            val color = when (game.result){
                MatchResult.WIN -> Color(0xFF4CAF50)
                MatchResult.LOSE -> Color(0xFFF44336)
                MatchResult.DRAW -> Color.Gray
            }
            Card(
                Modifier.fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    Modifier.padding(16.dp)
                ) {
                    Text(
                        text = game.result.name,
                        color = color,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Dificultad: ${game.difficulty}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}