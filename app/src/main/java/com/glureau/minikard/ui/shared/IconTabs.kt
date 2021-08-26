package com.glureau.minikard.ui.shared

import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun IconTab(modifier: Modifier, pagerState: PagerState) {
    val composableScope = rememberCoroutineScope()
    TabRow(modifier = modifier,
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        Screens.values().forEachIndexed { index, screen ->
            Tab(selected = pagerState.currentPage == index, onClick = {
                composableScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }, icon = {
                Icon(imageVector = screen.menuIcon, contentDescription = null)
            })
        }
    }
}

@ExperimentalPagerApi
@Composable
@Preview
fun IconTabPreview() {
    IconTab(Modifier, rememberPagerState(3, 1))
}