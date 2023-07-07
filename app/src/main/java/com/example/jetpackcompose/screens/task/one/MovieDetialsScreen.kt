package com.example.jetpackcompose.screens.task.one

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.Movie_Brown
import com.example.jetpackcompose.ui.theme.Movie_Gray
import com.example.jetpackcompose.ui.theme.Movie_Orange
import com.example.jetpackcompose.ui.theme.Movie_Text86
import com.example.jetpackcompose.ui.theme.Movie_White


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TestDetailsScreen() {
    DetailsScreen()
}

@Composable
fun DetailsScreen(
    viewModel: DetailsScreenViewModel = hiltViewModel()
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (image, card, lengthLabel, close, play) = createRefs()
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .clipToBounds()
                .scale(scaleX = 1f, scaleY = 1f)
                .offset(y = (-96).dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.image_poster),
            contentDescription = "Image poster",
            contentScale = ContentScale.FillWidth
        )

        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .clip(shape = CircleShape)
                .constrainAs(lengthLabel) {
                    top.linkTo(image.top, 24.dp)
                    end.linkTo(image.end, 16.dp)
                },
            colors = CardDefaults.cardColors(containerColor = Movie_Gray)
        ) {
            LengthLabel(viewModel.movie.length)
        }

        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .size(36.dp)
                .clip(shape = CircleShape)
                .constrainAs(close) {
                    top.linkTo(image.top, 24.dp)
                    start.linkTo(image.start, 16.dp)
                },
            colors = CardDefaults.cardColors(
                containerColor = Movie_Brown, contentColor = Movie_White
            ),
        ) {
            CloseIcon()
        }

        Card(
            elevation = CardDefaults.cardElevation(2.dp),
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .constrainAs(play) {
                    top.linkTo(image.top, 150.dp)
                    start.linkTo(image.start)
                    end.linkTo(image.end)
                },
            colors = CardDefaults.cardColors(
                containerColor = Movie_Orange, contentColor = Movie_White
            ),
        ) {
            PlayIcon()
        }

        Card(modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .constrainAs(card) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .clip(
                shape = RoundedCornerShape(
                    topStart = 24.dp, topEnd = 24.dp
                )
            ),
            elevation = CardDefaults.cardElevation(2.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            ConstraintLayout(modifier = Modifier.fillMaxSize()
            ) {
                val (booking,
                    description,
                    actors,
                    tags,
                    title,
                    state) = createRefs()

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(state) {
                        bottom.linkTo(title.top,4.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    ,horizontalArrangement = Arrangement.SpaceEvenly) {
                    MovieState(value = "6.8/10", label = "IMDB")
                    MovieState(value = "52%", label = "Rotten Tomatoes")
                    MovieState(value = "4/10", label = "IGN")
                }

                MovieTitle(text = viewModel.movie.title,
                    modifier = Modifier.constrainAs(title){
                        bottom.linkTo(tags.top,8.dp)
                        start.linkTo(parent.start,16.dp)
                        end.linkTo(parent.end,16.dp)
                    }
                )

                ChipsRecycler(list = viewModel
                    .movie.tags,
                    modifier = Modifier.constrainAs(tags){
                        bottom.linkTo(actors.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )

                ImagesRecycler(list = viewModel.movie.actors,
                    modifier = Modifier.constrainAs(actors){
                        bottom.linkTo(description.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

                MovieDescription(text = viewModel.movie.description,
                    modifier = Modifier.constrainAs(description){
                        bottom.linkTo(booking.top,8.dp)
                        start.linkTo(parent.start,16.dp)
                        end.linkTo(parent.end,16.dp)
                    })

                BookingLabel(label = "Booking", modifier = Modifier.constrainAs(booking){
                    bottom.linkTo(parent.bottom,16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            }
        }
    }
}

@Composable
fun MovieState(value: String,label: String,modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            textAlign = TextAlign.Center,
            fontSize = 12.sp, fontFamily = FontFamily.SansSerif,
            modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            color = Color.Black,
        )
        Text(
            text = label,
            textAlign = TextAlign.Center,
            fontSize = 12.sp, fontFamily = FontFamily.SansSerif,
            modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            color = Color.Gray,
        )
    }
}


@Composable
fun LengthLabel(length: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.padding(
                top = 4.dp, bottom = 4.dp, start = 4.dp, end = 2.dp
            ),
            alignment = Alignment.CenterStart,
            painter = painterResource(id = R.drawable.clock),
            contentDescription = "length icon"
        )
        Text(
            text = length,
            modifier = Modifier.padding(
                top = 4.dp, bottom = 4.dp, start = 2.dp, end = 4.dp
            ),
            color = Movie_White,
        )
    }
}

@Composable
fun BookingLabel(label: String,modifier: Modifier) {
    Card(modifier = modifier
        .clip(shape = RoundedCornerShape(corner = CornerSize(25.dp)))
        .size(width = 140.dp, height = 50.dp)

    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .background(color = Movie_Orange)
            ,verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier.padding(
                    top = 4.dp, bottom = 4.dp, start = 4.dp, end = 2.dp
                ),
                alignment = Alignment.CenterStart,
                painter = painterResource(id = R.drawable.card),
                contentDescription = "length icon"
            )
            Text(
                text = label,
                fontSize = 20.sp, fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(
                    top = 4.dp, bottom = 4.dp, start = 2.dp, end = 4.dp
                ),
                color = Movie_White,
            )
        }
    }
}


@Composable
fun CloseIcon(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.close), contentDescription = "close Icon"
        )
    }
}

@Composable
fun PlayIcon() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.play), contentDescription = "play Icon"
        )
    }
}

@Composable
fun MovieTitle(text:String,modifier: Modifier){
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 22.sp, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold,
        modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        color = Movie_Text86,
    )
}

@Composable
fun MovieDescription(text:String,modifier: Modifier){
    Text(textAlign = TextAlign.Center,
        text = text,
        modifier = modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun ImagesRecycler(list: List<String>,modifier: Modifier){
    LazyRow(contentPadding = PaddingValues(16.dp),modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(list){
            OneImage(painter = painterResource(id = R.drawable.knight))
        }
    }
}

@Composable
fun OneImage(painter: Painter){
    Image(painter = painter, contentDescription = "actor image",
        modifier = Modifier
            .size(60.dp)
            .clip(shape = CircleShape)
            .background(color = Color.Red))
}

@Composable
fun ChipsRecycler(list: List<String>,modifier: Modifier){
    LazyRow(modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        items(list){
            OneChip(it,modifier)
        }
    }
}

@Composable
fun OneChip(text: String, modifier: Modifier){
    Card(modifier = modifier
        .clip(shape = RoundedCornerShape(corner = CornerSize(25.dp)))
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .border(
            width = 0.5.dp,
            color = Color.LightGray,
            RoundedCornerShape(corner = CornerSize(24.dp))
        )
        , shape = CardDefaults.outlinedShape,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 14.sp, fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            color = Movie_Text86,
        )
    }
}