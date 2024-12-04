package com.statussaver.whatsavekaro.views.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.statussaver.whatsavekaro.navigation.Screens

@Composable
fun BottomNavigation(
    navController: NavController,
    selectedLanguage: String,
    onLanguageChanged: (String) -> Unit
) {
    val item = listOf(
        Screens.ImagesScreen,
        Screens.VideosScreen,
        Screens.Saved,
        Screens.SettingScreen
    )

    NavigationBar(containerColor = Color(0XFF008069)) {
        val navStack by navController.currentBackStackEntryAsState()
        val current = navStack?.destination?.route
        item.forEach {
            NavigationBarItem(
                selected = current == it.route,
                onClick = {
                    navController.navigate(it.route) {
                        navController.graph.let {
                            it.route?.let { it1 -> popUpTo(it1) }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    if (current == it.route) {
                        Icon(
                            imageVector = it.selectedIcon,
                            contentDescription = "",
                            tint = Color.White
                        )
                    } else {
                        Icon(
                            imageVector = it.unSelectedIcon,
                            contentDescription = "",
                            tint = Color(0XFF70a59b)
                        )
                    }
                },
                label = {
                    Text(
                        text = it.getTitle(selectedLanguage),
                        color = if (current == it.route) Color.White else Color(0XFF70a59b),
                        fontWeight = FontWeight.Medium
                    )
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
            )
        }
    }
}