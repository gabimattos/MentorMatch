package br.com.fiap.mentormatch.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CadastroScreen(navController: NavController) {

    var nome = remember {
        mutableStateOf("")
    }

    var idade = remember {
        mutableStateOf("")
    }

    var estado = remember {
        mutableStateOf("")
    }

    var cidade = remember {
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
                    text = "Crie sua conta",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 25.dp)
                        .height(500.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
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

                        // nome
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            value = nome.value,
                            onValueChange = { nome.value = it },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }),
                            label = {
                                Text(text = "Nome")
                            },
                        )

                        // idade
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            value = idade.value,
                            onValueChange = { idade.value = it },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }),
                            label = {
                                Text(text = "Idade")
                            },
                        )

                        // estado
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            value = estado.value,
                            onValueChange = { estado.value = it },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }),
                            label = {
                                Text(text = "Estado")
                            },
                        )

                        // cidade
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            value = cidade.value,
                            onValueChange = { cidade.value = it },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }),
                            label = {
                                Text(text = "Cidade")
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
                                            "experiencia")
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

//                                ElevatedButton(
//
//                                    onClick = {
//                                        navController.navigate(
//                                            "mentor")
//                                    },
//                                    modifier = Modifier
//                                        .size(width = 150.dp, height = 60.dp)
//                                ) {
//                                    Text(
//                                        text = "Mentor",
//                                        fontSize = 20.sp,
//                                        color = Color(0xffFD7979)
//                                    )
//                                }
                            }

                        }


                    }
                }
            }
        }
    }
}

