package com.example.tugas1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.tugas1.R

@Composable
fun AvatarScreen(navController: NavController) {
    var tampilRambut by remember { mutableStateOf(true) }
    var tampilMata by remember { mutableStateOf(true) }
    var tampilHidung by remember { mutableStateOf(true) }
    var tampilMulut by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                "Avatar",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Avatar dengan layer wajah + komponen
            Box(
                modifier = Modifier
                    .size(500.dp) // ukuran wajah
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                // Wajah dasar selalu tampil
                Image(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = "Wajah Dasar",
                    modifier = Modifier.fillMaxSize()
                )

                if (tampilRambut) {
                    Image(
                        painter = painterResource(R.drawable.rambut),
                        contentDescription = "Rambut",
                        modifier = Modifier
                            .size(200.dp)   // rambut lebih kecil
                            .offset(y = (-50).dp) // lebih naik ke atas
                    )
                }
                if (tampilMata) {
                    Image(
                        painter = painterResource(R.drawable.mata),
                        contentDescription = "Mata",
                        modifier = Modifier
                            .size(180.dp)
                            .offset(y = -10.dp)
                    )
                }
                if (tampilHidung) {
                    Image(
                        painter = painterResource(R.drawable.hidung),
                        contentDescription = "Hidung",
                        modifier = Modifier
                            .size(50.dp)
                            .offset(y = 30.dp)
                    )
                }
                if (tampilMulut) {
                    Image(
                        painter = painterResource(R.drawable.mulut),
                        contentDescription = "Mulut",
                        modifier = Modifier
                            .size(80.dp)   // sedikit lebih kecil
                            .offset(y = 80.dp) // mulut lebih ke atas
                    )
                }
            }
                Spacer(modifier = Modifier.height(20.dp))

            // Checkbox baris horizontal
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                CheckItem("Rambut", tampilRambut) { tampilRambut = it }
                CheckItem("Mata", tampilMata) { tampilMata = it }
                CheckItem("Hidung", tampilHidung) { tampilHidung = it }
                CheckItem("Mulut", tampilMulut) { tampilMulut = it }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.navigate("profile") }) {
                Text("Kembali ke Profil")
            }
        }
    }
}

@Composable
fun CheckItem(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.size(18.dp) // ukuran visual checkbox
        )
        Spacer(modifier = Modifier.width(8.dp)) // jarak antara checkbox & teks
        Text(label, fontSize = 12.sp)
    }
}
