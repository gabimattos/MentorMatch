package br.com.fiap.mentormatch.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mentormatch.model.Usuario
import br.com.fiap.mentormatch.repository.getAllUsuarios
import br.com.fiap.mentormatch.repository.getUsuariosByCidade
import br.com.fiap.mentormatch.repository.getUsuariosByDisponibilidade
import br.com.fiap.mentormatch.repository.getUsuariosByInteresse
import br.com.fiap.mentormatch.repository.getUsuariosByNivel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(navController: NavController) {

    var searchInteresseState by remember {
        mutableStateOf("")
    }
    var searchCidadeState by remember {
        mutableStateOf("")
    }
    var searchNivelState by remember {
        mutableStateOf("")
    }
    var searchDisponibilidadeState by remember {
        mutableStateOf("")
    }

    var usuariosListState by remember {
        mutableStateOf(getAllUsuarios())
    }


    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffECA1A1))
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()


        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)

            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    IconButton(onClick = {
                        navController.navigate(
                            "login")

                    }) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "",
                            Modifier.size(25.dp),


                        )
                    }

                    Text(
                        text = "MentorMatch",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xffFD7979)
                    )

                    IconButton(onClick = {
                        navController.navigate(
                            "meuperfil")

                    }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "",
                            Modifier.size(25.dp),

                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .background(Color(0xffECA1A1))
            ) {

                Text(
                    text = "Mentores e aprendizes cadastrados",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )


                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = searchInteresseState,

                    onValueChange = {
                        searchInteresseState = it
                        usuariosListState = getUsuariosByInteresse(searchInteresseState)

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }),
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Área de Interesse")
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            usuariosListState = getUsuariosByInteresse(searchInteresseState)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = ""
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    value = searchCidadeState,

                    onValueChange = {
                        searchCidadeState = it
                        usuariosListState = getUsuariosByCidade(searchCidadeState)

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }),
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Cidade")
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            usuariosListState = getUsuariosByCidade(searchCidadeState)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = ""
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    value = searchDisponibilidadeState,

                    onValueChange = {
                        searchDisponibilidadeState = it
                        usuariosListState = getUsuariosByDisponibilidade(searchDisponibilidadeState)

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }),
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Disponibilidade")
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            usuariosListState = getUsuariosByInteresse(searchInteresseState)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = ""
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(){
                    items(usuariosListState) {
                        UsuarioCard(usuario = it, navController)
                    }
                }
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsuarioCard(usuario: Usuario, navController: NavController) {
    Card(
        onClick = {
            Log.d("UsuarioCard", "Usuario clicado: $usuario")
            navController.navigate(
            "perfil?" +
                    "nome=${usuario.nome}&"+
                    "cidade=${usuario.cidade}&" +
                    "interesse=${usuario.interesse}&" +
                    "experiencia=${usuario.experiencia}&" +
                    "nivel=${usuario.nivel}&" +
                    "disponibilidade=${usuario.disponibilidade}")
      },
        modifier = Modifier
            .padding(bottom = 8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults
            .cardColors(containerColor = Color(0xffFFFFFF)),

        ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column (
                modifier = Modifier
                    .padding(12.dp)
            ){
                Text(
                    text = usuario.nome,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xffFD7979)
                )

                Text(
                    text = usuario.cidade,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    text = "Experiência: ${usuario.experiencia} ano(s)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )

            }
            Column (
                modifier = Modifier
                    .padding(12.dp)){
                Text(
                    text = usuario.interesse,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xffFD7979)
                )

                Text(
                    text = usuario.nivel,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = usuario.disponibilidade,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }

        }
    }
}