package com.glureau.minikard.ui.shared

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.glureau.minikard.ui.home.HomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

// Use enum ordinal to order app screens
enum class Screens(val menuIcon: ImageVector) {
    KarDeals(Icons.Filled.MailOutline),
    Home(Icons.Filled.Home),
    Profile(Icons.Filled.AccountBox)
}

@ExperimentalMaterialApi
@ExperimentalPagerApi // https://google.github.io/accompanist/pager/
@Composable
fun MiniKardPager() {
    val pagerState = rememberPagerState(
        pageCount = Screens.values().count(),
        initialPage = Screens.Home.ordinal
    )
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxHeight()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
        ) { page ->
            when (page) {
                Screens.KarDeals.ordinal -> ToDoScreen("KarDeals")
                Screens.Home.ordinal -> HomeScreen()
                Screens.Profile.ordinal -> ToDoScreen("Profile")
            }
        }
    }

    Box(Modifier.fillMaxSize()) {
        IconTab(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            pagerState = pagerState
        )
    }
}

@ExperimentalPagerApi
@Composable
fun ToDoScreen(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h1,
        )
    }
}
