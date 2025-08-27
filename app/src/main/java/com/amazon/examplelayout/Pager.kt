package com.amazon.examplelayout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.amazon.examplelayout.ui.theme.Purple40
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Composable
fun horizontalPager(){
    Box(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(pageCount = {
            10
        })
        LaunchedEffect(pagerState) {
            // Collect from the a snapshotFlow reading the currentPage
            snapshotFlow { pagerState.currentPage }.collect { page ->
                // Do something with each page change, for example:
                // viewModel.sendPageSelectedEvent(page)
                Log.d("Page change", "Page changed to $page")
            }
        }
        val fling = PagerDefaults.flingBehavior(
            state = pagerState,
            pagerSnapDistance = PagerSnapDistance.atMost(10)
        )
        Column(Modifier.align(Alignment.BottomCenter)) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .weight(1f)
                    .padding(20f.dp)
                    .background(Purple40),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                flingBehavior = fling
            ) { page ->
                Card(
                    Modifier
                        .fillMaxSize()
                        .padding(end = if (page == pagerState.pageCount - 1) 0.dp else 16.dp)
                        .wrapContentHeight()
                        .graphicsLayer {
                            // Calculate the absolute offset for the current page from the
                            // scroll position. We use the absolute value which allows us to mirror
                            // any effects for both directions
                            val pageOffset = (
                                    (pagerState.currentPage - page) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            // We animate the alpha, between 50% and 100%
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(), // Box chiếm toàn bộ Card
                        contentAlignment = Alignment.Center // Căn giữa cả theo chiều ngang và dọc
                    ) {
                        Text(
                            text = "Hello ${page}",
                            textAlign = TextAlign.Center // căn giữa text trong TextView (nếu text dài)
                        )
                    }
                }
            }
            nextPage(pagerState)
            indicator(pagerState)
        }
    }
}

@Composable
fun nextPage(pagerState: PagerState) {
    val couroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxWidth() // Box chiếm toàn màn hình
    ) {
        Button(
            onClick = {
                // launch coroutine để scroll pager
                couroutineScope.launch {
                    pagerState.animateScrollToPage(5)
                }
            },
            modifier = Modifier
                .align(Alignment.Center) // căn giữa Box
                .padding(bottom = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.White
            )
        ) {
            Text("Jump to Page 5")
        }
    }
}

@Composable
fun indicator(pagerState: PagerState) {
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }
}

private val threePagesPerViewport = object : PageSize {
    override fun Density.calculateMainAxisPageSize(
        availableSpace: Int,
        pageSpacing: Int
    ): Int {
        return (availableSpace - 2 * pageSpacing) / 3
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
