package com.statussaver.whatsavekaro.views.screens

import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.statussaver.whatsavekaro.navigation.Screens
import com.statussaver.whatsavekaro.utils.loadImageBitmap
import java.io.File

const val TAG = "WhatsApp Status"

@Composable
fun  DisplayWhatsappStatus(navController: NavController){

    val status = remember {  mutableStateListOf<File>()   }

    LaunchedEffect(Unit) {
        val whatsappStatusFolder = File(
            Environment.getExternalStorageDirectory()
                .toString() + "/Android/media/com.whatsapp/WhatsApp/Media/.Statuses"
        )

        if(whatsappStatusFolder.exists()){
            val statusFiles = whatsappStatusFolder.listFiles{ file ->
                file.extension.lowercase() in listOf("jpg","jpeg","png")
            }

            if(statusFiles !=null){
                status.addAll(statusFiles)
            }else{
                Log.d(TAG, "No Image Files Found")
            }

        } else {
            Log.e(TAG, "Folder not found")
        }
    }

    if(status.isEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "No Images Found", style = MaterialTheme.typography.bodyLarge)
        }
    } else {

        LazyVerticalGrid(columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp),
            contentPadding = PaddingValues(5.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(status){ statusFile ->
                val bitmap = loadImageBitmap(statusFile)

                if(bitmap!=null){
                    Box(modifier = Modifier.fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                Screens.PicDetail.route + "/${
                                    Uri.encode(statusFile.absolutePath)
                                }"
                            )
                        }.aspectRatio(1f)
                    ){
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = "WhatsApp Status Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

        }
    }

}