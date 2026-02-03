package com.example.tictactoe

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tictactoe.ActionSelector


@Composable
fun TicTacToeScreen(state: GameState, vm: TicTacToeViewModel) {
    Gamebody(state, vm, )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameTopBar(state: GameState, vm: TicTacToeViewModel){
    TopAppBar(
        title = { Text("3 en raya") },
          actions = {
              ActionSelector(state.difficulty, vm)
          }
    )
}
@Composable
fun Gamebody(state: GameState, vm: TicTacToeViewModel) {
    Column(
            Modifier.fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = state.score.human.toString(), fontSize = 20.sp)
            Text(text = state.score.draws.toString(), fontSize = 20.sp)
            Text(text = state.score.ai.toString(), fontSize = 20.sp)
        }
        Spacer(Modifier.height(4.dp))
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text("Tu")
            Text("Empate")
            Text("Ia")
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = when(state.winner){
                "X" -> "Has ganado "
                "O" -> "Ganan la maquina"
                "Draw" -> "Empate"
                else -> "Tu turno"
            },
            style = MaterialTheme.typography.titleMedium
        )
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            Column(
                Modifier.padding(12.dp)
                    .background(MaterialTheme.colorScheme.surface),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                board(state, vm)
            }
        }
        Spacer(Modifier.height(80.dp))
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Button({
                vm.resetBoard()
            }) { Text("Nueva ronda")}
            Button({
                vm.resetAll()
            }) {Text("Reset total") }
        }
    }
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun  GameBottomBar(navController: NavController){
    BottomAppBar {
        Row {
            IconButton({
                navController.navigate("jugar")
            }) {
                Icon(Icons.Default.PlayArrow, contentDescription = "juego")
            }
            IconButton({ navController.navigate("historia") }) {
                Icon(Icons.Default.AccountBox, contentDescription = "Historia")
            }
            MandarApp()
        }

    }
}
@Composable
fun MandarApp(){
val context = LocalContext.current

    IconButton({
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(
                Intent.EXTRA_TEXT,
                "¡Mira este juego increíble de Tres en raya! Descárgalo y juega ahora"
            )
            putExtra(
                Intent.EXTRA_SUBJECT,
                "Juego 3 en ralla"
            )
        }
        context.startActivity(
            Intent.createChooser(shareIntent, "Compartir juego")
        )
    }) {
        Icon(Icons.Default.Share,
        contentDescription = "Mandar juego")
    }
}
@Composable
fun ActionSelector(selected: Difficulty, vm: TicTacToeViewModel){
    Row {
        Button({
            vm.setDifficulty(Difficulty.EASY) },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(selected == Difficulty.EASY) Color(0xFF4CAF50) else Color.LightGray
            )
            ) { Text("Facil")}
        Button({
            vm.setDifficulty(Difficulty.HARD)},
            colors = ButtonDefaults.buttonColors(
                containerColor = if(selected == Difficulty.HARD)Color(0xFF4CAF50) else Color.LightGray
            )
            ) { Text("Deficil")}
    }

}

@Composable
fun board(state: GameState, vm: TicTacToeViewModel){
    Column{
        for (row in 0..2){
            Row {
                for (col in 0..2){
                    val index = row * 3 + col
                    Box(
                        Modifier.size(90.dp)
                            .border(1.dp, Color.Gray)
                            .clickable {
                                vm.onCellClicked(index)
                            },
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = state.board[index],
                            fontSize = 36.sp,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                }
            }
        }
    }
}