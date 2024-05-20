package br.com.fiap.mentormatch.screens

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MatchScreen(navController: NavController,
                nome:String?,
                cidade:String?,
                interesse:String?,
                nivel:String?){

    AlertDialogExample(navController, nome, cidade, interesse, nivel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    navController: NavController,
                       nome:String?,
                       cidade:String?,
                       interesse:String?,
                        nivel:String?

) {
    Log.d("nome","$nome")
    AlertDialog(

        title = {

            Text(
                text = "DEU MATCH!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffFD7979)
            )
        },
        text = {

            Text(
                text = "Você deu Match com o(a) $nivel $nome!\n\nInteresse: $interesse\nCidade: $cidade\n\nEntre em contato!",
                fontSize = 19.sp,
            )

        },

        onDismissRequest = {

        },
        confirmButton = {
            TextButton(
                onClick = {
                    navController.navigate(
                        "busca")
                }
            ) {
                Text("Ok")
            }
        },

    )
}