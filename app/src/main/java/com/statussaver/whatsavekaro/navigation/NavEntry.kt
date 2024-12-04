package com.statussaver.whatsavekaro.navigation

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.statussaver.whatsavekaro.utils.Preferences
import com.statussaver.whatsavekaro.views.components.BottomNavigation


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavEntry() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val preferences = remember { Preferences(context) }

    var selectedLanguage by remember {
        mutableStateOf(preferences.getSelectedLanguage())
    }

    LaunchedEffect(selectedLanguage) {
       preferences.setSelectedLanguage(selectedLanguage)
    }


    var showBottomNav by remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    showBottomNav = when {
        currentRoute == null -> true
        currentRoute.startsWith(Screens.VideoDetail.route) -> false
        currentRoute.startsWith(Screens.PicDetail.route) -> false
        currentRoute.startsWith(Screens.Privacy_Policy.route) -> false
        currentRoute.startsWith(Screens.TermsScreen.route) -> false
        else -> true
    }

    Scaffold(
        bottomBar = {
            if (showBottomNav) {
                BottomNavigation(
                    navController = navController,
                    selectedLanguage = selectedLanguage,
                    onLanguageChanged = { newLanguage ->
                        selectedLanguage = newLanguage
                    }
                )
            }
        }
    ) {
        Navigation(navController = navController, selectedLanguage = selectedLanguage, onLanguageChanged = { newLang -> selectedLanguage = newLang })
    }
}

