package com.glureau.minikard.ui.shared

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheet(
    content: @Composable (PaddingValues) -> Unit,
    sheetContent: @Composable () -> Unit,
    target: Any?,// Changing the target will re-open the bottom sheet automatically
    onClose: () -> Unit = {},
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )
    val state = bottomSheetScaffoldState.bottomSheetState.currentValue
    if (state == BottomSheetValue.Collapsed) {
        LaunchedEffect(key1 = state) {
            onClose()
        }
    }

    val coroutineScope = rememberCoroutineScope()
    if (target != null) {
        DisposableEffect(key1 = bottomSheetScaffoldState.bottomSheetState, key2 = target) {
            when {
                bottomSheetScaffoldState.bottomSheetState.isCollapsed -> {
                    coroutineScope.launch { bottomSheetScaffoldState.bottomSheetState.expand() }
                }
            }
            onDispose {
                coroutineScope.launch { bottomSheetScaffoldState.bottomSheetState.collapse() }
            }
        }
    }
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = { sheetContent() },
        content = content,
        sheetPeekHeight = 0.dp
    )
}