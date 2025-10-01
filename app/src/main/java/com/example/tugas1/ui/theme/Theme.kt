package com.example.tugas1.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Palet tetap
private val BluePrimary = Color(0xFF468BE6) // tombol, aksen
private val White       = Color(0xFFFEFEFE) // background & surface
private val TextDark    = Color(0xFF0E0E0E) // teks utama di atas putih
private val GreyStroke  = Color(0xFFD9D9D9) // outline/stroke/divider

// Skema warna (SELALU LIGHT)
private val LightColors = lightColorScheme(
    primary             = BluePrimary,
    onPrimary           = White,

    background          = White,
    onBackground        = TextDark,
    surface             = White,
    onSurface           = TextDark,

    // Material3 pakai "outline" utk border/stroke
    outline             = GreyStroke,
    outlineVariant      = GreyStroke,

    // Optional biar komponen outlined tetap konsisten
    secondary           = BluePrimary,
    onSecondary         = White,
    surfaceVariant      = White,
    onSurfaceVariant    = TextDark
)

@Composable
fun PATheme(content: @Composable () -> Unit) {
    // Paksa LIGHT MODE (BG putih) tanpa mengikuti system dark theme
    MaterialTheme(
        colorScheme = LightColors,
        typography  = MaterialTheme.typography,
        shapes      = MaterialTheme.shapes,
        content     = content
    )
}
