package com.statussaver.whatsavekaro.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
) {
    object ImagesScreen : Screens(
        "Images", Icons.Filled.Image, Icons.Outlined.Image
    )

    object VideosScreen : Screens(
        "Videos", Icons.Filled.VideoLibrary, Icons.Outlined.VideoLibrary
    )

    object Saved : Screens(
        "Saved", Icons.Filled.Bookmarks, Icons.Outlined.BookmarkBorder
    )

    object SettingScreen : Screens(
        "Setting", Icons.Filled.Settings, Icons.Outlined.Settings
    )

    object VideoDetail : Screens(
        "VideoDetail", Icons.Filled.Settings, Icons.Outlined.Settings
    )

    object PicDetail : Screens(
        "PicDetail", Icons.Filled.Settings, Icons.Outlined.Settings
    )

    object Privacy_Policy : Screens(
        "Privacy_Policy", Icons.Filled.Settings, Icons.Outlined.Settings
    )

    object TermsScreen : Screens(
        "TermsScreen", Icons.Filled.Settings, Icons.Outlined.Settings
    )

    fun getTitle(language: String): String {
        return when (this) {
            is ImagesScreen -> when (language) {
                "Hindi" -> "तस्वीर"
                "Gujarati" -> "ચિત્ર"
                "Bhojpuri" -> "फोटू"
                else -> "Images"
            }

            is VideosScreen -> when (language) {
                "Hindi" -> "वीडियो"
                "Gujarati" -> "વિડિઓ"
                "Bhojpuri"-> "वीडियो"
                else -> "Videos"
            }

            is Saved -> when (language) {
               "Hindi"-> "सहेजा"
                "Gujarati" -> "સાચવ્યું"
                "Bhojpuri" -> "बचावल"
                else -> "Saved"
            }

            is SettingScreen -> when (language) {
                "Hindi" -> "सेटिंग्स"
                "Gujarati" -> "સેટિંગ્સ"
                "Bhojpuri" -> "सेटिंग्स"
                else -> "Settings"
            }

            is VideoDetail -> when (language) {
                "Hindi" -> "वीडियो विवरण"
                "Gujarati" -> "વિડિઓ વિગત"
                "Bhojpuri" -> "वीडियो डिटेल"
                else -> "Video Detail"
            }

            is PicDetail -> when (language) {
                "Hindi" -> "तस्वीर विवरण"
                "Gujarati" -> "ચિત્ર વિગત"
                "Bhojpuri" -> "फोटू डिटेल"
                else -> "Picture Detail"
            }

            Privacy_Policy -> when (language) {
                "Hindi" -> "गोपनीयता नीति"
                "Gujarati" -> "ગોપનીયતા નીતિ"
                "Bhojpuri" -> "गोपनीयता नीति"
                else -> "Privacy Policy"
            }

            TermsScreen -> when(language){
                "Hindi" -> "सेवा की शर्तें"
                "Gujarati" -> "સેવાની શરતો"
                "Bhojpuri" -> "सेवा के शर्त"

                else -> "Terms of Service"
            }
        }
    }
}