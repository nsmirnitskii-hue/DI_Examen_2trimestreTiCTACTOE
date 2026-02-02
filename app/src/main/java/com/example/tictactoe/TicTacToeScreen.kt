package com.example.tictactoe



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun TicTacToeScreen() {
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


}



















