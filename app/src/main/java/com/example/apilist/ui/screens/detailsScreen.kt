@file:Suppress("MISSING_DEPENDENCY_SUPERCLASS_IN_TYPE_ARGUMENT")

package com.example.apilist.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.example.apilist.ui.components.Lockk
import com.example.apilist.ui.components.ThinCircle
import com.example.apilist.viewmodel.Screen1ViwModel


@Composable
fun DetailsSc(viwModel: Screen1ViwModel, navigateBack: () -> Unit) {
    viwModel.getCharacters()
    val index = viwModel.indexDetails.observeAsState(0)
    val buttonFollowStats = viwModel.buttonFollow.observeAsState(0)


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Referencias
        val (
            flecha,
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
            botonSeguir,
            circuloVacioParaCandado,
            candado,
            textoPerfilPrivado,
        ) = createRefs()
        val textoPerfilPrivadoDetalles = createRef()


        val guiaTop = createGuidelineFromTop(0.05f)
        val guiaTopPerfilDetails = createGuidelineFromTop(0.109f)
        val guiaStart = createGuidelineFromStart(0.02f)
        val guiaEnd = createGuidelineFromEnd(0.02f)
        val guiaEspacioEntreLaFlechaYelUser = createGuidelineFromStart(0.1f)
        val guiaEspacioEntreImagenYDatos = createGuidelineFromStart(0.34f)
        val guiaEspacioEntrePublicacionYSeguidores = createGuidelineFromStart(0.56f)
        val guiaEspacioEntreSeguidoresYSiguiendo = createGuidelineFromStart(0.78f)
        val guiaEspacioEntreLosNumerosYElTexto = createGuidelineFromTop(0.19f)
        val guiaEspacioEntreImagenYBio = createGuidelineFromTop(0.25f)
        val guiaEspacioEntreBioYBoton = createGuidelineFromTop(0.33f)
        val guiaEspacioEntreBotonYCandado = createGuidelineFromTop(0.50f)
        val guiaEspacioEntreCandadoYTextoPrivado = createGuidelineFromTop(0.7f)
        val guiaEspacioEntreTextoPrivadoYTextoPrivadoDetails = createGuidelineFromTop(0.76f)




        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .constrainAs(flecha) {
                    top.linkTo(guiaTop)
                    start.linkTo(guiaStart)

                }
                .clickable { navigateBack() })
        Text(
            viwModel.characters.value?.get(index.value)!!.name.first,
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
            painter = rememberAsyncImagePainter(viwModel.characters.value?.get(index.value)!!.picture.large),
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
                })
        Text(
            "${viwModel.characters.value?.get(index.value)!!.name.first} ${
                viwModel.characters.value?.get(
                    index.value
                )!!.name.last
            }",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(nombre) {
                start.linkTo(guiaEspacioEntreImagenYDatos)
                top.linkTo(imagePerfil.top, margin = 5.dp)

            })


        ////////////////////////////////////////////////////////////////////////////////A
        // PUBLICACIÓN
        Text(
            "${viwModel.characters.value?.get(index.value)!!.dob.age  / 3}",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(publicaciones) {
                start.linkTo(nombre.start)
                top.linkTo(imagePerfil.top)
                bottom.linkTo(imagePerfil.bottom)
            })


        Text(
            "publicación",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.constrainAs(publicaciones_text) {
                start.linkTo(nombre.start)
                top.linkTo(guiaEspacioEntreLosNumerosYElTexto)
            })
        ////////////////////////////////////////////////////////////////////////////////A
        // SEGUIDORES

        Text(
            " ${viwModel.characters.value?.get(index.value)!!.dob.age *5} ",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(seguidores) {
                top.linkTo(imagePerfil.top)
                start.linkTo(guiaEspacioEntrePublicacionYSeguidores)
                bottom.linkTo(imagePerfil.bottom)
            })


        Text(
            "seguidores",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.constrainAs(seguidores_text) {
                start.linkTo(seguidores.start)
                top.linkTo(guiaEspacioEntreLosNumerosYElTexto)
            })


        ////////////////////////////////////////////////////////////////////////////////A
        // SIGUIENDO
        Text(
            "${viwModel.characters.value?.get(index.value)!!.dob.age *5 - 105}",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(siguiendo) {
                top.linkTo(imagePerfil.top)
                start.linkTo(guiaEspacioEntreSeguidoresYSiguiendo)
                bottom.linkTo(imagePerfil.bottom)
            })


        Text(
            "siguiendo",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.constrainAs(siguiendo_text) {
                start.linkTo(siguiendo.start)
                top.linkTo(guiaEspacioEntreLosNumerosYElTexto)
            })


        // BIOGRAFIA

        Text(
            "${viwModel.characters.value?.get(index.value)!!.nat}📍\nedad: ${viwModel.characters.value?.get(index.value)!!.dob.age}",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(biografia) {
                top.linkTo(guiaEspacioEntreImagenYBio)
                start.linkTo(imagePerfil.start)
                end.linkTo(imagePerfil.end)

            })

        Button(
            onClick = { viwModel.changeStatButoonFollor(index.value) },
            shape = RoundedCornerShape(12.dp),
            colors = if (buttonFollowStats.value == false){ButtonDefaults.buttonColors(containerColor = Color(74, 93, 249))} else {ButtonDefaults.buttonColors(containerColor = Color.DarkGray, contentColor = Color.White)},
            modifier = Modifier
                .fillMaxWidth(0.96f)
                .constrainAs(botonSeguir) {
                    start.linkTo(guiaStart)
                    end.linkTo(guiaEnd)
                    top.linkTo(guiaEspacioEntreBioYBoton)

                }) {
            Text(if (buttonFollowStats.value == false){"Seguir"} else{"Siguiendo"})
        }

        // Diseño de la cuenta es privada

        // Icono

        Icon(
            imageVector = Icons.Outlined.ThinCircle,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .constrainAs(circuloVacioParaCandado) {
                    start.linkTo(guiaStart)
                    end.linkTo(guiaEnd)
                    top.linkTo(guiaEspacioEntreBotonYCandado)
                }
                .size(150.dp))

        Icon(
            imageVector = Icons.Filled.Lockk,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .constrainAs(candado) {
                    top.linkTo(circuloVacioParaCandado.top)
                    bottom.linkTo(circuloVacioParaCandado.bottom)
                    start.linkTo(circuloVacioParaCandado.start)
                    end.linkTo(circuloVacioParaCandado.end)
                }
                .size(100.dp))

        Text(
            "Esta cuenta es privada",
            fontWeight = FontWeight.W900,
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier.constrainAs(textoPerfilPrivado) {
                top.linkTo(guiaEspacioEntreCandadoYTextoPrivado)
                start.linkTo(circuloVacioParaCandado.start)
                end.linkTo(circuloVacioParaCandado.end)

            })

        Text(
            "Sigue esta cuenta para ver fotos y vídeos",
            fontWeight = FontWeight.Normal,
            color = Color.LightGray,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(textoPerfilPrivadoDetalles) {
                top.linkTo(guiaEspacioEntreTextoPrivadoYTextoPrivadoDetails)
                start.linkTo(circuloVacioParaCandado.start)
                end.linkTo(circuloVacioParaCandado.end)

            })

    }


}
