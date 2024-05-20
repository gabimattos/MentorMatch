package br.com.fiap.mentormatch.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ExperienciaScreen(navController: NavController){

    var interesse = remember {
        mutableStateOf("")
    }

    var experiencia = remember {
        mutableStateOf("")
    }

    var nivel = remember {
        mutableStateOf("")
    }

    var disponibilidade = remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffECA1A1))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp),

                ) {
                Text(
                    text = "Experiencia e Interesses",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 25.dp)
                        .height(500.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults
                        .cardColors(containerColor = Color(0xffFFFFFF)),


                    ) {

                    Column(
                        modifier = Modifier.padding(
                            start = 22.dp,
                            end = 22.dp,
                            top = 18.dp,
                            bottom = 30.dp
                        ),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly,


                        ) {

                        // interesse
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            value = interesse.value,
                            onValueChange = { interesse.value = it },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }),
                            label = {
                                Text(text = "Área de Interesse")
                            },
                        )


                        // experiencia
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            value = experiencia.value,
                            onValueChange = { experiencia.value = it },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }),
                            label = {
                                Text(text = "Experiência em Anos")
                            },
                        )

                        // nivel
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            value = nivel.value,
                            onValueChange = { nivel.value = it },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }),
                            label = {
                                Text(text = "Nível")
                            },
                        )

                        // disponibilidade
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            value = disponibilidade.value,
                            onValueChange = { disponibilidade.value = it },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }),
                            label = {
                                Text(text = "Disponibilidade")
                            },
                        )

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 30.dp),

                                horizontalArrangement = Arrangement.SpaceAround
                            ) {


                                ElevatedButton(

                                    onClick = {
                                        navController.navigate(
                                            "cadastro")
                                    },
                                    modifier = Modifier
                                        .size(width = 150.dp, height = 60.dp)

                                    ) {
                                    Text(
                                        text = "Voltar",
                                        fontSize = 20.sp,
                                        color = Color(0xffFD7979)
                                    )
                                }

                                ElevatedButton(

                                    onClick = {
                                        navController.navigate(
                                            "validacao")
                                    },
                                    modifier = Modifier
                                        .size(width = 150.dp, height = 60.dp)
                                ) {
                                    Text(
                                        text = "Continuar",
                                        fontSize = 20.sp,
                                        color = Color(0xffFD7979)
                                    )
                                }
                            }

                        }


                    }
                }
            }
        }
    }
}