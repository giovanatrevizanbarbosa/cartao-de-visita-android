package com.example.cartaodevisita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartaodevisita.ui.theme.CartãoDeVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartãoDeVisitaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CartaoVisita(
                        fullName = "Jennifer Doe",
                        title = "Android Developer Extraordinaire",
                        phone = "+11 (123) 444 555 666",
                        social = "@AndroidDev",
                        email = "jen.doe@android.com",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ImagemTituloCartao(modifier: Modifier = Modifier) {
    val imagem = painterResource(R.drawable.android_logo)
    Image(
        painter = imagem,
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun InfoCartao(icone: ImageVector, descricao: String?, texto: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 80.dp)
    ) {
        Icon(
            imageVector = icone,
            contentDescription = descricao,
            tint = Color(0xFF007846),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = texto,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun TituloCartao(fullName: String, title: String, modifier: Modifier = Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
                           .wrapContentHeight()
    ) {
        ImagemTituloCartao(
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .background(Color(0xFF073042))
                .padding(10.dp)
        )
        Text(
            text = fullName,
            fontSize = 50.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF007846)
        )
    }
}

@Composable
fun CartaoVisita(
    fullName: String,
    title: String,
    phone: String,
    social: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFd2e8d4))
            .padding(vertical = 24.dp)
    ) {
        TituloCartao(fullName, title)
        Spacer(modifier = Modifier.padding(80.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            InfoCartao(Icons.Filled.Phone, "Telefone", phone)
            InfoCartao(Icons.Filled.Share, "Compartilhar", social)
            InfoCartao(Icons.Filled.Email, "E-mail", email)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CartãoDeVisitaTheme {
        CartaoVisita(
            fullName = "Jennifer Doe",
            title = "Android Developer Extraordinaire",
            phone = "+11 (123) 444 555 666",
            social = "@AndroidDev",
            email = "jen.doe@android.com"
        )
    }
}