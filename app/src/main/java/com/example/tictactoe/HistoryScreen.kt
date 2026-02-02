package com.example.tictactoe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryScreen() {
    //Vamos a utilizar el state almacenado en el view model

    //Elegimos una estructura que ocupe el maximo espacio posible
    //y tenga un padding de 16.dp
    //Anadimos el titulo Historial de partidas personalizalo con tipografia
    //del tema del proyecto
    //Si el historial de partidas esta vacio veremos el mensaje Aun no hay partidas
    //Realizamos una lista con scroll y anadimos los elementos almacenados en state.history

    //Utilizamos los siguientes colores dependiendo de si hemos ganado, perdido o empatado
    //la partida:
    /*MatchResult.WIN -> Color(0xFF4CAF50)
    MatchResult.LOSE -> Color(0xFFF44336)
    MatchResult.DRAW -> Color(0xFFFFC107)*/

    //Para cada registro utilizamos lo siguiente:
    /*Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){}*/
    //Tambien anadimos result.difficulty.name para saber en que modo hemos jugado
}