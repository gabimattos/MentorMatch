package br.com.fiap.mentormatch

import android.content.Context
import androidx.compose.runtime.compositionLocalOf

val LocalMainActivityContext = compositionLocalOf<Context> {
    error("No MainActivity Context found")
}
