package com.example.apilist.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.apilist.ui.screens.FavoritesSc
import com.example.apilist.viewmodel.Screen1ViwModel
import kotlin.math.log

@Composable
fun InstagramProfile(profileImage: String, name: String, indice: Int, viewModel: Screen1ViwModel,  navController: NavController) {
    val buttonFollowStats = viewModel.buttonFollow.observeAsState(0)

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(10.dp)
            .clickable { viewModel.setIndeDetials(indice)
                Log.d("CHIVATO","$indice")
                navController.navigate("pantalla11/$indice")


            },
        verticalAlignment = Alignment.CenterVertically

    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(74.dp) // Un poco más grande que la imagen
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFEDA75), Color(0xFFFA7E1E),
                            Color(0xFFD62976), Color(0xFF962FBF),
                            Color(0xFF4F5BD5)
                        )
                    ),
                    shape = CircleShape
                )
        ) {
            Column {
                // Imagen de perfil
                Image(
                    painter = rememberAsyncImagePainter(profileImage),
                    contentDescription = "Imagen de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(68.dp)
                        .clip(CircleShape)
                        .background(Color.Black) // fondo interior negro (modo oscuro)
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "$name\n ",
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )

        Button(
            onClick = {},
            shape = RoundedCornerShape(12.dp),
            colors = if (buttonFollowStats.value == false){ButtonDefaults.buttonColors(containerColor = Color(74, 93, 249))} else {ButtonDefaults.buttonColors(containerColor = Color.DarkGray, contentColor = Color.White)},
        ) {
            Text("seguir")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Previeww() {
    Spacer(Modifier.padding(bottom = 50.dp)) }