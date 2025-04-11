@file:Suppress("MISSING_DEPENDENCY_SUPERCLASS_IN_TYPE_ARGUMENT")

package com.example.apilist.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter


@Composable
fun DetailsScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Referencias
        val (flecha,
            user,
            tresPuntitos,
            imagePerfil,
            nombre,
            publicaciones,
            seguidores,
            siguiendo,
            publicaciones_text,
            seguidores_text,
            siguiendo_text,
            biografia,
            botonSeguir) = createRefs()


        val guiaTop = createGuidelineFromTop(0.05f)
        val guiaTopPerfilDetails = createGuidelineFromTop(0.109f)
        val guiaStart = createGuidelineFromStart(0.02f)
        val guiaEnd = createGuidelineFromEnd(0.02f)
        val guiaEspacioEntreLaFlechaYelUser = createGuidelineFromStart(0.1f)
        val guiaEspacioEntreImagenYDatos = createGuidelineFromStart(0.27f)
        val guiaEspacioEntrePublicacionYSeguidores = createGuidelineFromStart(0.57f)
        val guiaEspacioEntreSeguidoresYSiguiendo = createGuidelineFromStart(0.8f)
        val espacioEntreImagenYBio = createGuidelineFromTop(0.4f)


        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .constrainAs(flecha) {
                    top.linkTo(guiaTop)
                    start.linkTo(guiaStart)

                }
                .clickable { TODO() })
        Text(
            "iagomzzh",
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(user) {

                start.linkTo(guiaEspacioEntreLaFlechaYelUser)
                bottom.linkTo(flecha.bottom)
                top.linkTo(flecha.top)

            })

        Icon(
            imageVector = Icons.Default.MoreHoriz,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.constrainAs(tresPuntitos) {
                top.linkTo(flecha.top)
                end.linkTo(guiaEnd)

            })


        Image(
            painter = rememberAsyncImagePainter("https://randomuser.me/api/portraits/women/66.jpg"),
            contentDescription = "Imagen de perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Black)
                .constrainAs(imagePerfil) {
                    top.linkTo(guiaTopPerfilDetails)
                    start.linkTo(guiaStart)
                    end.linkTo(user.end)
                }
        )
        Text(
            "Iago Martínez",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(nombre) {
                start.linkTo(guiaEspacioEntreImagenYDatos, margin = 30.dp)
                top.linkTo(imagePerfil.top, margin = 5.dp)

            })


        ////////////////////////////////////////////////////////////////////////////////A
        // PUBLICACIÓN
        Text(
            "46", color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(publicaciones) {
                start.linkTo(nombre.start)
                top.linkTo(imagePerfil.top)
                bottom.linkTo(imagePerfil.bottom)
            }
        )


        Text(
            "publicación", color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.constrainAs(publicaciones_text) {
                start.linkTo(nombre.start)
                top.linkTo(publicaciones.bottom, margin = 2.dp)
            }
        )
        ////////////////////////////////////////////////////////////////////////////////A
        // SEGUIDORES

        Text(
            "450", color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(seguidores) {
                top.linkTo(imagePerfil.top)
                start.linkTo(guiaEspacioEntrePublicacionYSeguidores)
                bottom.linkTo(imagePerfil.bottom)
            }
        )


        Text(
            "seguidores", color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.constrainAs(seguidores_text) {
                start.linkTo(seguidores.start)
                top.linkTo(publicaciones.bottom, margin = 2.dp)
            }
        )


        ////////////////////////////////////////////////////////////////////////////////A
        // SIGUIENDO
        Text(
            "448", color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(siguiendo) {
                top.linkTo(imagePerfil.top)
                start.linkTo(guiaEspacioEntreSeguidoresYSiguiendo)
                bottom.linkTo(imagePerfil.bottom)
            }
        )


        Text(
            "siguiendo", color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.constrainAs(siguiendo_text) {
                start.linkTo(siguiendo.start)
                top.linkTo(publicaciones.bottom, margin = 2.dp)
            }
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    DetailsScreen()
}