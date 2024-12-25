package com.thit.composewidgetproject.navigation

sealed class Screen(val route: String) {
    data object MainScreen: Screen("main_screen")
    data object BottomSheetScreen : Screen("bottom_sheet_screen")
}
