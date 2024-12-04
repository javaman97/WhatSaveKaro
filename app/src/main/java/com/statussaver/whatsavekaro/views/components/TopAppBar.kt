package com.statussaver.whatsavekaro.views.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(selectedLang:String){

    TopAppBar(title ={
        Text(
            text = when (selectedLang) {
                "Hindi" -> "स्टेटस इमेजेस"
                "Gujarati" -> "સ્થિતિ છબીઓ"
                "Bhojpuri" -> "स्टेटस इमेजेस"
                else -> "WhatSaveKaro "
            },
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatusTopAppBar(selectedLang:String){
    TopAppBar(title ={
        Text(
            text = when (selectedLang) {
                "Hindi" -> "स्टेटस इमेजेस"
                "Gujarati" -> "સ્થિતિ છબીઓ"
                "Bhojpuri" -> "स्टेटस इमेजेस"
                else -> "Status Images"
            },
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    })
}