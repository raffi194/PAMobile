package com.example.tugas1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas1.ui.* // AvatarScreen, dll.
import com.example.tugas1.ui.theme.PATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PATheme {
                AppNav()
            }
        }
    }
}

@Composable
private fun AppNav() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background // Selalu #FEFEFE
    ) {
        // HANYA AVATAR YANG DIBUKA
        NavHost(navController = navController, startDestination = "avatar") {
            composable("avatar")   { AvatarScreen(navController) }

            // ====== DISIMPAN UNTUK NANTI (DI-COMMENT SEMENTARA) ======
            // composable("register") { RegisterScreen(navController) }
            // composable("login")    { LoginScreen(navController) }
            // composable("profile")  { ProfileScreen(navController) }
            // =========================================================
        }
    }
}
