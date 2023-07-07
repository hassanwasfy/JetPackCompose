package com.example.jetpackcompose.screens.task.three

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.screens.task.one.ChipsRecycler
import com.example.jetpackcompose.ui.theme.Movie_Orange
import com.example.jetpackcompose.ui.theme.Movie_Shine
import com.example.jetpackcompose.ui.theme.Movie_White


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TestHomeScreen() {
    HomeScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(bottomBar = { BottomBar() }, containerColor = Movie_Shine) {
        val movies = MovieFactory().movies
        val state = rememberPagerState()
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(
                    id = movies[state.currentPage].poster
                ),
                contentDescription = "",
                modifier = Modifier
                    .clipToBounds()
                    .blur(32.dp)
                    .fillMaxWidth(1.5f)
                    .fillMaxHeight(0.5f),
                alpha = 0.8f,
            )
            Column {
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.height(80.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Header()
                }
                Spacer(modifier = Modifier.height(24.dp))
                HorizontalPager(
                    pageCount = movies.size, modifier = Modifier.fillMaxWidth(), state = state
                ) { index ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        val offset = (state.currentPage - index) + state.currentPageOffsetFraction
                        val size by animateFloatAsState(
                            targetValue = if (offset != 0.0f) 2f else 1f,
                            animationSpec = tween(durationMillis = 300)
                        )
                        val currentMovie = movies[index]
                        Image(painter = painterResource(id = currentMovie.poster),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .clip(shape = RoundedCornerShape(corner = CornerSize(24.dp)))
                                .graphicsLayer {
                                    scaleX = size
                                    scaleY = size
                                })

                        MovieLengthLabel(length = currentMovie.length)
                        Text(
                            text = currentMovie.name,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        ChipsRecycler(
                            list = currentMovie.tags, modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomBar() {
    NavigationBar(
        modifier = Modifier, containerColor = Movie_Shine
    ) {
        NavigationBarItem(icon = { painterResource(id = R.drawable.ic_video_play) },
            label = { },
            selected = true,
            onClick = { })
        NavigationBarItem(icon = { painterResource(id = R.drawable.ic_search) },
            label = { },
            selected = false,
            onClick = { })
        NavigationBarItem(icon = { painterResource(id = R.drawable.ic_ticket) },
            label = { },
            selected = false,
            onClick = { })
        NavigationBarItem(icon = { painterResource(id = R.drawable.ic_user) },
            label = { },
            selected = false,
            onClick = { })
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
            "Morbius",
            R.drawable.mv_1,
            "2h 33m",
            listOf("Fantasy", "Action", "Sci Fi", "Horror")
        ),
        ShowMovie(
            "Dr Strange\nMultiverse om Madness",
            R.drawable.mv_2,
            "2h 33m",
            listOf("Sci Fi", "Horror")
        ),
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