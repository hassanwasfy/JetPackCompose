package com.example.jetpackcompose.screens.contacts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
@Composable
fun ContactsScreen() {
    StickyHeaderRecyclerView()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeaderRecyclerView(viewModel: ContactsViewModel = hiltViewModel()) {
    val groupedItems = viewModel.namesList.groupBy { it.first().uppercaseChar() }
    LazyColumn {
        groupedItems.forEach { (header, items) ->
            stickyHeader {
                ItemHeader(header = header)
            }
            items(items) { item ->
                ItemName(item = item)
            }
        }
    }
}
@Composable
fun ItemHeader(header: Char){
    Text(
        text = header.toString(),
        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
    )
}
@Composable
fun ItemName(item: String){
    Text(
        text = item,
        style = TextStyle(fontSize = 16.sp),
        modifier = Modifier.padding(8.dp)
    )
}