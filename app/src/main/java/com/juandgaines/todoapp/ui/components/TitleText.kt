package com.juandgaines.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.juandgaines.todoapp.ui.theme.ToDoPurple

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    message: String = "Title Text",
){
    Text(
        modifier = modifier,
        text = message,
        color = ToDoPurple,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        maxLines = 1,
        textAlign = TextAlign.End
    )
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
fun TitleTextPreview(){
    TitleText(
        modifier = Modifier.background(
            color = Color.Black,
            shape = CircleShape
        ).padding(

        ),
    )
}