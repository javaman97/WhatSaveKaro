package com.statussaver.whatsavekaro.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.statussaver.whatsavekaro.views.screens.PrivacyPolicy
import com.statussaver.whatsavekaro.views.screens.WhatsAppStatusScreen

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun Navigation(
    navController: NavHostController,
    selectedLanguage: String,
    onLanguageChanged: (String) -> Unit
) {
    NavHost(navController = navController, startDestination = Screens.ImagesScreen.route) {
        composable(Screens.ImagesScreen.route) {
            WhatsAppStatusScreen(navController, selectedLanguage)
        }
        composable(Screens.VideosScreen.route) {
            Videos(navController = navController, selectedLanguage)
        }
        composable(Screens.Saved.route) {
            Saved(navController = navController, selectedLanguage)
        }
        composable(Screens.SettingScreen.route) {
            SettingScreen(
                navController = navController,
                selectedLanguage = selectedLanguage,
                onLanguageChanged = onLanguageChanged
            )
        }
        composable(Screens.VideoDetail.route + "/{videoPath}") { backStackEntry ->
            val videoPath = backStackEntry.arguments?.getString("videoPath")
            if (videoPath != null) {
                VideoDetail(navController = navController, videoPath, selectedLanguage)
            }
        }

        composable(Screens.PicDetail.route + "/{PicPath}") { backStackEntry ->
            val PicPath = backStackEntry.arguments?.getString("PicPath")
            if (PicPath != null) {
                PicDetail(navController = navController, PicPath, selectedLanguage)
            }
        }

        composable(Screens.Privacy_Policy.route) {
            PrivacyPolicy(navController = navController)
        }
        composable(Screens.TermsScreen.route) {
            TermsandConditionScreen(navController)
        }
    }
}