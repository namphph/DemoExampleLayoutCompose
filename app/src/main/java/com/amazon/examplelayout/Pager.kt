package com.amazon.examplelayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amazon.examplelayout.ui.theme.Purple40

@Composable
fun horizontalPager(){
    val pagerState = rememberPagerState(pageCount = {
        10
    })
    HorizontalPager(state =  pagerState, modifier = Modifier.padding(20f.dp).background(Purple40)) {
        Text(
            text = "Hello"+ it.toString(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun verticalPager(){
    val pagerState = rememberPagerState(pageCount = {
        10
    })
    VerticalPager(state = pagerState) { page ->
        // Our page content
        Text(
            text = "Page: $page",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
