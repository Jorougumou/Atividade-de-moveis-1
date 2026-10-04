package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaTela()
        }
    }
}

@Composable
fun MinhaTela() {
    var quantidade by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Sabor do Sertão", fontSize = 24.sp)
        Text(text = "Comida nordestina caseira")

        Row(
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        ) {
            Text(text = "Nota: 4.9")
            Text(text = "  |  Tempo: 40 min", modifier = Modifier.padding(start = 8.dp))
        }

        Text(text = "Prato: Carne de Sol", fontSize = 18.sp)
        Text(text = "Preço: R$ 38,50")

        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Button(onClick = {
                if (quantidade > 1) {
                    quantidade = quantidade - 1
                }
            }) {
                Text(text = "-")
            }

            Text(
                text = "  $quantidade  ",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Button(onClick = {
                quantidade = quantidade + 1
            }) {
                Text(text = "+")
            }
        }

        Button(onClick = { }) {
            Text(text = "FAZER PEDIDO")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTela() {
    MinhaTela()
}