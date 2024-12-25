package com.thit.composewidgetproject.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thit.composewidgetproject.presentation.BottomSheetScreen
import com.thit.composewidgetproject.presentation.MainScreen

fun NavGraphBuilder.bottomSheetScreen(navController: NavController) {
    composable(route = Screen.BottomSheetScreen.route) {
        BottomSheetScreen()
    }
}

fun NavGraphBuilder.mainScreen(navController: NavController) {
    composable(route = Screen.MainScreen.route) {
        MainScreen(navController = navController)
    }
}