package com.example.jetpackcompose.screens.task.three

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.screens.task.one.ChipsRecycler
import com.example.jetpackcompose.ui.theme.Movie_Orange
import com.example.jetpackcompose.ui.theme.Movie_White
import kotlin.math.absoluteValue


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TestHomeScreen() {
    HomeScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val movies = MovieFactory().movies
    val state = rememberPagerState(initialPage = 1, pageCount = {movies.size})
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(
                id = movies[state.currentPage].poster
            ),
            contentDescription = "",
            modifier = Modifier
                .clipToBounds()
                .blur(24.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Transparent,
                            Color.White,
                            Color.Transparent,
                        )
                    )
                )
                .fillMaxWidth(1.5f)
                .fillMaxHeight(0.5f),
            contentScale = ContentScale.FillBounds,
            alpha = 0.8f,
        )
        Column {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.height(80.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Header()
            }
            Spacer(modifier = Modifier.height(24.dp))

            ViewPagerCards(modifier = Modifier,movies = movies, pagerState = state)


            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                MovieLengthLabel(length = movies[state.currentPage].length)
                Text(
                    text = movies[state.currentPage].name,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                ChipsRecycler(
                    list = movies[state.currentPage].tags,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OneBottomItem(icon = R.drawable.ic_video_play)
                OneBottomItem(icon = R.drawable.ic_search)
                OneBottomItem(icon = R.drawable.ic_ticket)
                OneBottomItem(icon = R.drawable.ic_user)
            }
        }
    }

}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPagerCards(
    modifier: Modifier = Modifier,
    movies: List<ShowMovie>,
    pagerState: PagerState,
) {
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        contentPadding = PaddingValues(start = 42.dp, end = 42.dp),
        pageSpacing = 16.dp
    ) { page ->
        Card(
            modifier = Modifier
                .aspectRatio(4f / 5.5f)
                .graphicsLayer {
                    val pageOffset =
                        (pagerState
                            .currentPage - page
                                + pagerState.currentPageOffsetFraction)
                            .absoluteValue

                    alpha = lerp(
                        start = 0.8f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceAtLeast(0f)
                    )

                    scaleY = lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceAtLeast(0f)
                    )
                },
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(32.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(movies[page].poster),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun OneBottomItem(icon: Int) {
    Card(
        modifier = Modifier.size(40.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "",
                alignment = Alignment.Center
            )
        }
    }
}


@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        NowShowingButton(label = "Now Showing")
        Spacer(modifier = Modifier.width(8.dp))
        ComingSoonButton(label = "Coming Soon")
    }
}

@Composable
fun ComingSoonButton(label: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .clip(shape = RoundedCornerShape(corner = CornerSize(48.dp)))
            .border(
                1.dp, color = Color.White, shape = RoundedCornerShape(corner = CornerSize(24.dp))
            )
            .size(width = 140.dp, height = 32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp, bottom = 4.dp, start = 2.dp, end = 4.dp
                    ),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun NowShowingButton(label: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .clip(shape = RoundedCornerShape(corner = CornerSize(48.dp)))
            .size(width = 140.dp, height = 32.dp),
        colors = CardDefaults.cardColors(containerColor = Movie_Orange)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp, bottom = 4.dp, start = 2.dp, end = 4.dp
                    ),
                color = Movie_White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MovieLengthLabel(length: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Image(
            modifier = Modifier.padding(
                top = 4.dp, bottom = 4.dp, start = 4.dp, end = 2.dp
            ),
            alignment = Alignment.CenterStart,
            painter = painterResource(id = R.drawable.clock),
            contentDescription = "length icon",
            colorFilter = ColorFilter.tint(Color.Black)
        )
        Text(
            text = length, fontSize = 14.sp,
            modifier = Modifier.padding(
                top = 4.dp, bottom = 4.dp, start = 2.dp, end = 4.dp
            ),
            color = Color.Black,
        )
    }
}


data class ShowMovie(
    val name: String, @DrawableRes val poster: Int, val length: String, val tags: List<String>
)

class MovieFactory {
    val movies = listOf(
        ShowMovie(
            "Dr Strange\nMultiverse om Madness",
            R.drawable.mv_3,
            "2h 33m",
            listOf("Fantasy", "Horror")
        ),
        ShowMovie("Morbius", R.drawable.mv_4, "2h 33m", listOf("Sci Fi")),
        ShowMovie(
            "The Secrets of DumbleDore\nreturn to the magic",
            R.drawable.mv_5,
            "2h 33m",
            listOf("Action", "Sci Fi")
        ),
    )
}