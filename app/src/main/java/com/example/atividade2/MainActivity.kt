package com.example.atividade2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.*
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atividade2.ui.theme.Atividade2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Atividade2Theme {
                teste()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun teste(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Eventos UFC")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        modifier = Modifier.fillMaxWidth()

    )
    {
        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)

                ) {
                    Text(
                        text = ("Workshop: Meu Primeiro App Android"),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Column(
                        modifier = Modifier
                            .padding(1.dp)
                    ) {
                        Text(text = "15 de Outubro / 14:00", style = MaterialTheme.typography.titleSmall)
                        Text(text = "Campos de Russas - Laboratorio 01", style = MaterialTheme.typography.titleSmall)
                    }
                    Column(
                        modifier = Modifier
                            .padding(1.dp)

                    ) {
                        Text(text = "Inscrição", style = MaterialTheme.typography.titleSmall)
                        Text(text = "Digite seu nome para demonstrar interesse:", style = MaterialTheme.typography.titleSmall)
                    }
                    var nome by remember { mutableStateOf("") }

                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = nome,
                        onValueChange = {novoTexto:String ->
                            nome = novoTexto
                        },
                        label = {Text("Nome")}

                    )
                    Button(
                        onClick = {

                        },
                        enabled = nome.isNotBlank(),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("QUERO PARTICIPAR")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Atividade2Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, name = "Tela de Inscrição Padrão")
@Composable
fun testePreview(){
    Atividade2Theme() {
        teste()
    }
}