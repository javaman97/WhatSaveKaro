package com.statussaver.whatsavekaro

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.statussaver.whatsavekaro.navigation.NavEntry
import com.statussaver.whatsavekaro.ui.theme.WhatSaveKaroTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatSaveKaroTheme {
                NavEntry()
            }
        }
    }
}
