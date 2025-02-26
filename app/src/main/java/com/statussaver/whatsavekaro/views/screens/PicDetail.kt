package com.statussaver.whatsavekaro.views.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.statussaver.whatsavekaro.utils.downloadImage
import java.io.File

@Composable
fun PicDetail(navController: NavController, picPath:String, selectedLang:String){
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        AsyncImage(model = picPath, contentDescription = "Whatsapp Pic Details", contentScale =
        ContentScale.Fit, modifier = Modifier.fillMaxSize())

        Icon(imageVector = Icons.Filled.ArrowBackIosNew,
            contentDescription = "",
            tint = Color.Magenta,
            modifier = Modifier.clickable {
                navController.navigateUp()
            }.align(Alignment.TopStart).padding(8.dp)
        )

        Icon(imageVector = Icons.Filled.CloudDownload,
            contentDescription = "Download",
            tint = Color.Magenta,
            modifier = Modifier.
            clickable {
                val file = File(picPath)
                downloadImage(context,file)
            }.align(Alignment.TopEnd)
                .padding(8.dp))

    }


}