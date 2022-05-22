package com.jorgepilo.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            personalData(name = "Pilo")
        }
    }

    @Composable
    private fun personalData(name: String) {
        MaterialTheme() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Hola, Soy Jorge Pilo Logo",
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Mi Nombre es $name", style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Soy Ingeniero de Software",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Hola, Soy Jorge Pilo",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }
        }
    }

    @Preview
    @Composable
    fun previewPersonalData() {
        personalData(name = "Pilo")
    }
}



