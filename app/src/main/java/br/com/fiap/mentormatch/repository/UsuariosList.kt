package br.com.fiap.mentormatch.repository

import br.com.fiap.mentormatch.R
import br.com.fiap.mentormatch.model.Usuario

fun getAllUsuarios(): List<Usuario>{
    return listOf(
        Usuario(id = 1, nome = "Minerva McGonagall", cidade = "Rio de Janeiro", interesse = "Transfiguração", experiencia = "101", nivel = "Mentor(a)", disponibilidade = "Disponível"),
        Usuario(id = 2, nome = "Luna Lovegood", cidade = "São Paulo", interesse = "Herbologia", experiencia = "1", nivel = "Aprendiz", disponibilidade = "Disponível"),
        Usuario(id = 3, nome = "Harry Potter", cidade = "Rio de Janeiro", interesse = "Poções", experiencia = "2", nivel = "Aprendiz", disponibilidade = "Disponível"),
        Usuario(id = 4, nome = "Hermione Granger", cidade = "São Paulo", interesse = "Poções", experiencia = "2", nivel = "Aprendiz", disponibilidade = "Disponível"),
        Usuario(id = 5, nome = "Rony Wesley", cidade = "Niterói", interesse = "Herbologia", experiencia = "1", nivel = "Aprendiz", disponibilidade = "Disponível"),
        Usuario(id = 6, nome = "Alvo Dumbledore", cidade = "Niterói", interesse = "Transfiguração", experiencia = "132", nivel = "Mentor(a)", disponibilidade = "Indisponível"),
        Usuario(id = 7, nome = "Serevo Snape", cidade = "Belo Horizonte", interesse = "Poções", experiencia = "26", nivel = "Mentor(a)", disponibilidade = "Indisponível"),
        Usuario(id = 8, nome = "Rúbeo Hagrid", cidade = "Salvador", interesse = "Criaturas Mágicas", experiencia = "41", nivel = "Mentor(a)", disponibilidade = "Indisponível"),
        Usuario(id = 9, nome = "Sirius Black", cidade = "Porto Alegre", interesse = "Arte das Trevas", experiencia = "33", nivel = "Mentor(a)", disponibilidade = "Indisponível"),
        Usuario(id = 10, nome = "Droco Malfoy", cidade = "Rio de Janeiro", interesse = "Arte das Trevas", experiencia = "0", nivel = "Aprendiz", disponibilidade = "Indisponível"),

    )
}

fun getUsuariosByCidade(cidade: String): List<Usuario>{
    return getAllUsuarios().filter{
        it.cidade.startsWith(prefix = cidade, ignoreCase = true)
    }
}

fun getUsuariosByInteresse(interesse: String): List<Usuario>{
    return getAllUsuarios().filter{
        it.interesse.startsWith(prefix = interesse, ignoreCase = true)
    }
}

fun getUsuariosByNivel(nivel: String): List<Usuario>{
    return getAllUsuarios().filter{
        it.nivel.startsWith(prefix = nivel, ignoreCase = true)
    }
}

fun getUsuariosByDisponibilidade(disponibilidade: String): List<Usuario>{
    return getAllUsuarios().filter{
        it.disponibilidade.startsWith(prefix = disponibilidade, ignoreCase = true)
    }
}