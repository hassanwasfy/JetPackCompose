package com.example.jetpackcompose.screens.task.two

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose.R
import kotlinx.coroutines.flow.MutableStateFlow


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TestBuyScreen() {
    //BuyScreen()
    //OneSeat()
    //SeatsSection()
    BuyScreen()
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BuyScreen(
    viewModel: BuyScreenViewModel = hiltViewModel()
) {
    var x = viewModel
    val left = remember { x.left.value }

    ConstraintLayout(
        modifier = Modifier
            .clickable {
                x = BuyScreenViewModel()
            }
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (close, seats) = createRefs()

        CloseIcons(
            modifier = Modifier.constrainAs(close) {
                top.linkTo(parent.top, 24.dp)
                start.linkTo(parent.start, 16.dp)
            }
        )

        SeatsSection(
            left = left,
            center = x.center.value,
            right = x.right.value,
            modifier = Modifier.constrainAs(seats) {
                top.linkTo(close.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}



@Composable
fun CloseIcons(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.close), contentDescription = "close Icon"
        )
    }
}

@Composable
fun SeatsSection(modifier: Modifier = Modifier,
                 left: List<Seat>,
                 center: List<Seat>,
                 right: List<Seat>) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        LazyColumn{
            items(left){currentSeat ->
                OneSeat(seat = currentSeat, modifier = Modifier.rotate(15f))
            }
        }
        LazyColumn(modifier = Modifier.padding(top = 8.dp)){
            items(center){currentSeat ->
                OneSeat(seat = currentSeat)
            }
        }
        LazyColumn{
            items(right){currentSeat ->
                OneSeat(seat = currentSeat,modifier = Modifier.rotate(-15f))
            }
        }
    }
}

@Composable
fun OneSeat(seat: Seat,modifier: Modifier = Modifier){
    Card(modifier = modifier.padding(vertical = 8.dp),colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
        Box() {
            Image(painter = painterResource(id = R.drawable.chair_borders),
                contentDescription = "")
            Column(modifier = Modifier.matchParentSize()) {
                Spacer(modifier = Modifier.height(4.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Image(painter = painterResource(id = routeImage(status = seat.one.status)),
                        contentDescription = "",modifier = Modifier)
                    Image(painter = painterResource(id = routeImage(status = seat.two.status)),
                        contentDescription = "")
                }
            }
        }
    }
}

@Composable
fun routeImage(status: ChairStatus): Int {
    return when(status){
        ChairStatus.SELECTED -> R.drawable.chair_selected
        ChairStatus.TAKEN -> R.drawable.chair_reserved
        else -> {R.drawable.chair_notselected}
    }
}
