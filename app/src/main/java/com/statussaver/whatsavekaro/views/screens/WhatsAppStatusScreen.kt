package com.statussaver.whatsavekaro.views.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.statussaver.whatsavekaro.utils.Preferences
import com.statussaver.whatsavekaro.views.components.MainTopAppBar
import com.statussaver.whatsavekaro.views.components.StatusTopAppBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WhatsAppStatusScreen(navController: NavController, selectedLanguage: String) {
   val permissionState = rememberPermissionState(permission = android.Manifest.permission.READ_EXTERNAL_STORAGE)

    LaunchedEffect (Unit){
        permissionState.launchPermissionRequest()
    }

    val context = LocalContext.current
    val preferences =  Preferences(context)
    var selectedLang by remember { mutableStateOf(preferences.getSelectedLanguage()) }


    Scaffold (
        topBar = { StatusTopAppBar(selectedLang = selectedLang) }
    ){
    }

}