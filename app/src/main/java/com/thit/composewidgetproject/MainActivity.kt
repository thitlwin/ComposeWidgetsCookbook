package com.thit.composewidgetproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thit.composewidgetproject.navigation.AppNavHost
import com.thit.composewidgetproject.ui.theme.ComposeWidgetProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController: NavHostController = rememberNavController()
            ComposeWidgetProjectTheme {
                AppNavHost(navController = navHostController)
            }
        }
    }
}