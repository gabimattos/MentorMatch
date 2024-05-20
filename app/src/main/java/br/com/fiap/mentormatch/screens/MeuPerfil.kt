package br.com.fiap.mentormatch.screens

import MatchNotificationService
import android.Manifest
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.mentormatch.LocalMainActivityContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MeuPerfilScreen(
    navController: NavController,
    nome:String?,
    cidade:String?,
    interesse:String?,
    experiencia:String?,
    nivel:String?,
    disponibilidade:String?

){
    val mainActivityContext = LocalMainActivityContext.current

    val postNotificationPermission=
        rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    val matchNotificationService=MatchNotificationService(mainActivityContext)
    LaunchedEffect(key1 = true ){
        if(!postNotificationPermission.status.isGranted){
            postNotificationPermission.launchPermissionRequest()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()


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
                            "busca")

                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
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
                            "perfil")

                    }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = ""
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 15.dp)
                    .background(Color(0xffECA1A1)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Card(
                    modifier = Modifier
                        .padding(25.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults
                        .cardColors(containerColor = Color(0xffFFFFFF))
                ){
                    Column (
                        modifier = Modifier.fillMaxWidth(),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly,

                        ){

                        Icon(
                            Icons.Rounded.AccountCircle,
                            contentDescription = "",
                            modifier = Modifier.size(128.dp)
                        )

                        Text(
                            text = "$nome",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xffFD7979)
                        )
                        Text(
                            text = "$cidade",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xffFD7979)

                        )
                        Spacer(modifier = Modifier.height(15.dp))


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
                                    text = "Experiência: $experiencia ano(s)",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal
                                )
                                Text(
                                    text = "$interesse",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xffFD7979)
                                )


                            }
                            Column (
                                modifier = Modifier
                                    .padding(12.dp)){

                                Text(
                                    text = "$nivel",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal
                                )
                                Text(
                                    text = "$disponibilidade",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            }

                        }
                    }
                }

            }


            Column(
                modifier = Modifier.padding(top = 15.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    IconButton(onClick = {
                        navController.navigate(
                            "login")
                    }) {
                        Icon(
                            Icons.Rounded.ExitToApp,
                            contentDescription = "",
                            modifier = Modifier
                                .size(80.dp),
                            tint = Color.Red
                        )
                    }

                    IconButton(
                        onClick =
                        {
                            navController.navigate(
                                "match?" +
                                        "nome=${nome}&"+
                                        "cidade=${cidade}&" +
                                        "interesse=${interesse}&" +
                                        "nivel=${nivel}")

                            matchNotificationService.showBasicNotification()


                        }


                    ) {
                        Icon(
                            Icons.Rounded.Edit,
                            contentDescription = "",
                            modifier = Modifier
                                .size(80.dp),
                            tint = Color.Black
                        )
                    }



                }
            }
        }
    }
}

