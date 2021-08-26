package com.glureau.minikard.ui.shared

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.glureau.minikard.ui.home.HomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@ExperimentalMaterialApi
@ExperimentalPagerApi // https://google.github.io/accompanist/pager/
@Composable
fun MiniKardPager() {
    val pagerState = rememberPagerState(pageCount = 3, initialPage = 1)
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxHeight()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
        ) { page ->
            when (page) {
                0 -> ToDoScreen("KarDeals", Color.Green)
                1 -> HomeScreen()
                else -> ToDoScreen("Profile", Color.Blue)
            }
            // Our page content
        }
    }

    Box(Modifier.fillMaxSize()) {
        IconTab(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomCenter),
            pagerState = pagerState
        )
    }
}

@ExperimentalPagerApi
@Composable
fun ToDoScreen(text: String, color: Color) {
    Surface(color = color, modifier = Modifier.fillMaxSize()) {
        Text(
            text = text,
        )
    }
}
