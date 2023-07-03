package com.example.jetpackcompose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.CustomCardSurface


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TestTextFieldItem() {
    TextFieldItem(label = "Hassan", info = "Wasfy") {}
}

@Composable
fun TextFieldItem(label: String, info: String,
onTextChanged: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(CustomCardSurface)
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(
                text = label, fontWeight = FontWeight.SemiBold, color = Color.Gray, fontSize = 12.sp
            )
            BasicTextField(value = info,
                onValueChange = onTextChanged)
        }
    }
}