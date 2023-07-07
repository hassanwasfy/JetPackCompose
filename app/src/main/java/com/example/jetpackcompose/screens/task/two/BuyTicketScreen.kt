package com.example.jetpackcompose.screens.task.two

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.Movie_Brown
import com.example.jetpackcompose.ui.theme.Movie_Gray
import com.example.jetpackcompose.ui.theme.Movie_Orange
import com.example.jetpackcompose.ui.theme.Movie_Shine
import com.example.jetpackcompose.ui.theme.Movie_Text60
import com.example.jetpackcompose.ui.theme.Movie_White

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TestBuyScreen() {
    BuyScreen()
}

@Composable
fun BuyScreen(
    viewModel: BuyScreenViewModel = hiltViewModel()
) {
    val left = viewModel.left.collectAsState().value
    val center = viewModel.center.collectAsState().value
    val right = viewModel.right.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        CloseIcons(modifier = Modifier)
        Image(painter = painterResource(id = R.drawable.poster_cover),
            contentDescription = "",
            modifier = Modifier
                .padding(vertical = 24.dp).fillMaxWidth().height(80.dp))
        SeatsSection(
            left = left, center = center, right = right, modifier = Modifier
        )
        CardBottom()
    }
}

@Composable
fun PriceAndBooking() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Column {
            Text(
                text = "$100.00",
                modifier = Modifier,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Normal,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "4 tickets",
                modifier = Modifier,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                color = Movie_Text60
            )
        }
        Column {
            BuyTickets(label = "Buy tickets")
        }
    }
}

@Composable
fun BuyTickets(label: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .clip(shape = RoundedCornerShape(corner = CornerSize(48.dp)))
            .size(width = 160.dp, height = 50.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Movie_Orange),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.padding(
                    top = 4.dp, bottom = 4.dp, start = 4.dp, end = 2.dp
                ),
                alignment = Alignment.CenterStart,
                painter = painterResource(id = R.drawable.card),
                contentDescription = "length icon"
            )
            Spacer(modifier = Modifier.width(4.dp))
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
fun CardBottom() {
    Card(
        modifier = Modifier.padding(vertical = 24.dp),
        colors = CardDefaults.cardColors(containerColor = Movie_Shine),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Column(modifier = Modifier.padding(vertical = 24.dp)) {
            LazyRow(
                contentPadding = PaddingValues(
                    start = 16.dp, end = 16.dp, bottom = 4.dp, top = 4.dp
                ), horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(Days().generateMonthDays(31, "Mon")) {
                    OneDayCard(day = it)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                contentPadding = PaddingValues(
                    start = 16.dp, end = 16.dp, bottom = 4.dp, top = 4.dp
                ), horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(Days().timeList()) {
                    OneChipCard(time = it)
                }
            }
            PriceAndBooking()
        }
    }
}


@Composable
fun OneChipCard(time: String) {
    Card(
        modifier = Modifier.border(
            1.dp, color = if (time != "18:00") Color.Black else Color.Transparent,
            shape = RoundedCornerShape(corner = CornerSize(24.dp)),

            ),
        colors = CardDefaults.cardColors(containerColor = if (time == "18:00") Movie_Brown else Movie_Shine)
    ) {
        Column(
            modifier = Modifier
                .width(64.dp)
                .height(32.dp)
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clip(shape = RoundedCornerShape(corner = CornerSize(24.dp))),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = time,
                color = if (time == "18:00") Movie_Shine else Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun OneDayCard(day: Day) {
    Card(
        modifier = Modifier.border(
            1.dp,
            color = if (day.dayNumber != 4) Color.Black else Color.Transparent,
            shape = RoundedCornerShape(corner = CornerSize(12.dp))
        ),
        colors = CardDefaults.cardColors(containerColor = if (day.dayNumber == 4) Movie_Brown else Movie_Shine)
    ) {
        Column(
            modifier = Modifier
                .width(48.dp)
                .height(64.dp)
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = day.dayNumber.toString(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = if (day.dayNumber == 4) Movie_Shine else Color.Black
            )

            Text(
                text = day.dayName,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = if (day.dayNumber == 4) Movie_Shine else Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun CloseIcons(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.close), contentDescription = "close Icon"
        )
    }
}

@Composable
fun SeatsSection(
    modifier: Modifier = Modifier, left: List<Seat>, center: List<Seat>, right: List<Seat>
) {
    Column {
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            LazyColumn {
                items(left) { currentSeat ->
                    OneSeat(seat = currentSeat, modifier = Modifier.rotate(15f))
                }
            }
            LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
                items(center) { currentSeat ->
                    OneSeat(seat = currentSeat)
                }
            }
            LazyColumn {
                items(right) { currentSeat ->
                    OneSeat(seat = currentSeat, modifier = Modifier.rotate(-15f))
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            OneChairState(text = "Available", colorFilter = Movie_White)
            OneChairState(text = "Taken", colorFilter = Movie_Gray)
            OneChairState(text = "Selected", colorFilter = Movie_Orange)
        }
    }
}

@Composable
fun OneChairState(text: String, colorFilter: Color) {
    Row(
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.height(4.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_circle_24),
            contentDescription = "",
            colorFilter = ColorFilter.tint(colorFilter),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text, color = Color.LightGray, textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OneSeat(seat: Seat, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.chair_borders), contentDescription = ""
            )
            Column(modifier = Modifier.matchParentSize()) {
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = routeImage(status = seat.one.status)),
                        contentDescription = "",
                        modifier = Modifier
                    )
                    Image(
                        painter = painterResource(id = routeImage(status = seat.two.status)),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
fun routeImage(status: ChairStatus): Int {
    return when (status) {
        ChairStatus.SELECTED -> R.drawable.chair_selected
        ChairStatus.TAKEN -> R.drawable.chair_reserved
        else -> {
            R.drawable.chair_notselected
        }
    }
}

