package com.thit.composewidgetproject.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen() {

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false // Show the half-expanded state if needed
    )
    val coroutineScope = rememberCoroutineScope()

    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(topBar = { MyTopAppBar("Bottom Sheet") }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
// Standard Bottom Sheet
            ShandardBottomSheet()
//            Modal Bottom Sheet
            Button(onClick = {
                coroutineScope.launch {
                    bottomSheetState.show()
                    showBottomSheet = true
                }
            }) {
                Text("Show Standard Bottom Sheet")
            }
            if (showBottomSheet)
                ModalBottomSheet(
                    sheetState = bottomSheetState,
                    onDismissRequest = {
                        coroutineScope.launch {
                            bottomSheetState.hide()
                            showBottomSheet = false
                        }
                    },
                ) {
                    SheetContent()
                }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShandardBottomSheet() {
    BottomSheetScaffold(
        sheetContent = {
            SheetContent()
        },
        scaffoldState = rememberBottomSheetScaffoldState()
    )
    {
        Text("Main Content")
    }
}

@Composable
fun SheetContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Bottom Sheet Title", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text("This is the content of the bottom sheet. You can customize it.")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Perform an action */ }) {
            Text("Perform Action")
        }
    }
}
