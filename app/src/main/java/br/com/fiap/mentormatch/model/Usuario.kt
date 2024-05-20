package br.com.fiap.mentormatch.model

import android.media.Image

data class Usuario (
    val id: Long=0,
    val nome: String = "",
    val cidade: String = "",
    val interesse: String = "",
    val experiencia: String = "",
    val nivel: String = "",
    val disponibilidade: String = ""
)
