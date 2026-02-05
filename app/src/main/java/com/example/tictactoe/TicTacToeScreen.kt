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
//TO DO:
//Vamos a trabajar con el estate guardado en el viewModel
//Hacemos que el contenido de la ventana se ajuste todo lo posible a la ventana
// y que tenga un padding de 16.dp y este centrado horizontalmente

//Anadimos el titulo 3 en raya usando tipografia definida en los estilos del proyecto
//Anadimos un espacio de 8.dp
//Anadimos dos botones para seleccionar la dificultad
//El boton que este seleccionado tiene que tener el color purple40 definido en Color.kt
//Al seleccionar el botón usaremos la funcion del viewmodel setDifficulty()

//Anadimos un espacio de 12.dp

//Para visualizar las partidas usamos Card (a poder ser)
//que ocupe el mayor espacio posible de ancho
//usa el parametro  elevation = CardDefaults.cardElevation(6.dp)
//para hacer sombra.
//para visualizar el contador de las partidas ganadas usamos state.score.human
//state.score.ai, state.score.draws usa una de las tipografias del tema del proyecto.

//Anade un espacio de 20.dp

//cuando haya ganador (state.winner) anade:
/*when () {
    "X" -> "¡Has ganado! 🎉"
    "O" -> "Gana la máquina 🤖"
    "Draw" -> "Empate 😐"
    else -> "Tu turno"*/

//Anadimos un espacio de 12.dp

//Anadimos el tablero:
//Para ello utilizamos el componente card con estos parametros
/*elevation = CardDefaults.cardElevation(8.dp),
    shape = RoundedCornerShape(16.dp)*/
//Dentro de la card usamos otras estructuras...
//A dichas estructuras les damos el color de fondo del surface
//y un padding de 12.dp
//en cada celda dibujamos el valor del state.board correspondiente
//A cada celda le damos las siguientes caracteristicas:
//tamano 90.dp
//borde 1.dp y Color.Gray
//Valores centrados y con tamano de 36.dp
//Cuando se hace click se llama a vm.onCellClicked(index)

//Anadimos un espacio de 20.dp
//Anadimos boton de nueva ronda llamando al metodo resetBoard()
//del view model

//Anadimos boton reset total llamando al metodo resetAll() del view model
