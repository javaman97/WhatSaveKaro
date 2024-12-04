package com.statussaver.whatsavekaro.utils

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import java.io.File


fun loadImageBitmap(file:File): android.graphics.Bitmap? {
    return BitmapFactory.decodeFile(file.absolutePath)
}

fun downloadImage(context: Context, file:File){

    try {
        val downloadsFolder = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            file.name
        )
        file.copyTo(downloadsFolder, overwrite = true)

        saveFileToPreferences(context, downloadsFolder.absolutePath)

        Toast.makeText(context, "Image saved to Downloads", Toast.LENGTH_SHORT).show()

        val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        intent.data = Uri.fromFile(downloadsFolder)
        context.sendBroadcast(intent)

    }catch (e:Exception){
        e.printStackTrace()
        Toast.makeText(context, "Failed to Download Image", Toast.LENGTH_SHORT).show()
    }
}
















