package br.com.fiap.mentormatch

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.mentormatch.screens.CadastroScreen
import br.com.fiap.mentormatch.screens.ExperienciaScreen
import br.com.fiap.mentormatch.screens.SearchScreen
import br.com.fiap.mentormatch.screens.LoginScreen
import br.com.fiap.mentormatch.screens.MatchScreen
import br.com.fiap.mentormatch.screens.PerfilScreen
import br.com.fiap.mentormatch.screens.ValidacaoScreen
import br.com.fiap.mentormatch.ui.theme.MentorMatchTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import androidx.compose.runtime.CompositionLocalProvider
import br.com.fiap.mentormatch.screens.MeuPerfilScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorMatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = this@MainActivity

                    val navController = rememberNavController()
                    CompositionLocalProvider(LocalMainActivityContext provides this){
                        NavHost(
                            navController = navController,
                            startDestination = "login"
                        ){
                            composable(route = "login"){
                                LoginScreen(navController = navController) }

                            composable(
                                route = "match?nome={nome}&cidade={cidade}&interesse={interesse}&nivel={nivel}",
                                arguments = listOf(
                                    navArgument("nome"){
                                        type = NavType.StringType
                                        defaultValue = "Gabriela"
                                    },
                                    navArgument("cidade"){
                                        type = NavType.StringType
                                        defaultValue = "Rio de Janeiro"
                                    },
                                    navArgument("interesse"){
                                        type = NavType.StringType
                                        defaultValue = "Arte das Trevas"
                                    },
                                    navArgument("nivel"){
                                        type = NavType.StringType
                                        defaultValue = "Mentor"
                                    },
                                )){

                                val nome: String?= it.arguments?.getString("nome", "")
                                val cidade: String?= it.arguments?.getString("cidade", "")
                                val interesse: String?= it.arguments?.getString("interesse", "")
                                val nivel: String? = it.arguments?.getString("nivel", "")

                                MatchScreen(navController, nome!!, cidade!!, interesse!!, nivel!!) }

                            composable(route = "cadastro"){
                                CadastroScreen(navController = navController) }

                            composable(route = "validacao"){
                                ValidacaoScreen(navController = navController) }

                            composable(route = "experiencia"){
                                ExperienciaScreen(navController = navController) }

                            composable(
                                route = "perfil?nome={nome}&cidade={cidade}&interesse={interesse}&experiencia={experiencia}&nivel={nivel}&disponibilidade={disponibilidade}",
                                arguments = listOf(
                                    navArgument("nome"){
                                        type = NavType.StringType
                                        defaultValue = "Gabriela"
                                    },
                                    navArgument("cidade"){
                                        type = NavType.StringType
                                        defaultValue = "Rio de Janeiro"
                                    },
                                    navArgument("interesse"){
                                        type = NavType.StringType
                                        defaultValue = "Arte das Trevas"
                                    },
                                    navArgument("experiencia"){
                                        type = NavType.StringType
                                        defaultValue = "3"
                                    },
                                    navArgument("nivel"){
                                        type = NavType.StringType
                                        defaultValue = "Mentor"
                                    },
                                    navArgument("disponibilidade"){
                                        type = NavType.StringType
                                        defaultValue = "Disponível"
                                    },

                                    )

                            ){
                                val nome: String?= it.arguments?.getString("nome", "")
                                val cidade: String?= it.arguments?.getString("cidade", "")
                                val interesse: String?= it.arguments?.getString("interesse", "")
                                val experiencia: String? = it.arguments?.getString("experiencia", "")
                                val nivel: String? = it.arguments?.getString("nivel", "")
                                val disponibilidade: String?= it.arguments?.getString("disponibilidade", "")

                                PerfilScreen(navController, nome!!, cidade!!, interesse!!, experiencia!!, nivel!!, disponibilidade!!) }

                            composable(
                                route = "meuperfil?nome={nome}&cidade={cidade}&interesse={interesse}&experiencia={experiencia}&nivel={nivel}&disponibilidade={disponibilidade}",
                                arguments = listOf(
                                    navArgument("nome"){
                                        type = NavType.StringType
                                        defaultValue = "Gabriela Mattos"
                                    },
                                    navArgument("cidade"){
                                        type = NavType.StringType
                                        defaultValue = "Rio de Janeiro"
                                    },
                                    navArgument("interesse"){
                                        type = NavType.StringType
                                        defaultValue = "Transfiguração"
                                    },
                                    navArgument("experiencia"){
                                        type = NavType.StringType
                                        defaultValue = "0"
                                    },
                                    navArgument("nivel"){
                                        type = NavType.StringType
                                        defaultValue = "Aprendiz"
                                    },
                                    navArgument("disponibilidade"){
                                        type = NavType.StringType
                                        defaultValue = "Disponível"
                                    },

                                    )

                            ){
                                val nome: String?= it.arguments?.getString("nome", "")
                                val cidade: String?= it.arguments?.getString("cidade", "")
                                val interesse: String?= it.arguments?.getString("interesse", "")
                                val experiencia: String? = it.arguments?.getString("experiencia", "")
                                val nivel: String? = it.arguments?.getString("nivel", "")
                                val disponibilidade: String?= it.arguments?.getString("disponibilidade", "")

                                MeuPerfilScreen(navController, nome!!, cidade!!, interesse!!, experiencia!!, nivel!!, disponibilidade!!) }



                            composable(route = "busca"){
                                SearchScreen(navController = navController) }
                        }
                    }


                }
            }
        }
    }
}

