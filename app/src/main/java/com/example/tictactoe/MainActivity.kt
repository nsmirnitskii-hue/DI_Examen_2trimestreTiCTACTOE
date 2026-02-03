package com.example.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tictactoe.ui.theme.TicTacToeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme{
                val navController = rememberNavController()
                val vm: TicTacToeViewModel = viewModel()
                val state by vm.state.collectAsState()
                Scaffold(
                    topBar = {GameTopBar(state, vm )},
                    bottomBar = {GameBottomBar(navController)}
                ) {
                    AppNavigation(navController, vm, state )
                }
            }

        }
    }
}
@Composable
fun AppNavigation(nv: NavHostController, vm: TicTacToeViewModel, state: GameState){
    NavHost(nv, startDestination = "jugar"){
        composable("jugar"){TicTacToeScreen(state, vm)}
        composable("historia"){HistoryScreen(state)}
    }
}