package com.example.atividade01dm.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.atividade01dm.R

@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen(
    navController: NavController
) {

    var email by rememberSaveable { mutableStateOf("duarte.teste2025") }
    var nome by rememberSaveable { mutableStateOf("Gustavo") }

    val showAlert = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.images),
                    contentDescription = null,
                    modifier = Modifier
                        .size(192.dp)
                        .clip(CircleShape)
                )

//                Button(
//                    onClick = {
//
//                    },
//                    shape = CircleShape,
//                    contentPadding = PaddingValues(0.dp),
//                    modifier = Modifier
//                        .size(50.dp)
//                        .align(Alignment.BottomEnd),
//                    colors = ButtonDefaults.buttonColors(Color(0xFFA09E9E))
//                ) {
//
//
//                }
            }

            Text(text = nome, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(text = email, fontSize = 14.sp)

            Button(
                onClick = { showAlert.value = true },
                modifier = Modifier
                    .padding(top = 300.dp)
                    .width(83.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF39A048))

            ) {
                Text(
                    text = "Sair",
                    style = TextStyle(
                        color = Color.White
                    )
                )
            }

            if (showAlert.value) {
                AlertDialog(
                    onDismissRequest = {
                        showAlert.value = false
                    },
                    title = {
                        Text(text = "Você deseja realmente sair?")
                    },
                    text = {
                        Text("Não será possível acessar informações e receber notificações pessoais.")
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                showAlert.value = false
                                navController.navigate("login")
                            }
                        ) {
                            Text(text = "Sair")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { showAlert.value = false }) {
                            Text(text = "Cancelar")
                        }
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun InicioScreenPreview() {
    InicioScreen(rememberNavController())
}
