package com.jorgepilo.practice_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jorgepilo.practice_3.ui.theme.Practice3Theme


private val messages: List<MyMessage> = listOf(
    MyMessage(
        title = "Titulo 1",
        body = "Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1 - Body 1"
    ),
    MyMessage(
        title = "Titulo 2",
        body = "Body 2 - Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2- Body 2"
    ),
    MyMessage(title = "Titulo 3", body = "Body 3"),
    MyMessage(title = "Titulo 4", body = "Body 4"),
    MyMessage(title = "Titulo 5", body = "Body 5"),
    MyMessage(title = "Titulo 6", body = "Body 6"),
    MyMessage(title = "Titulo 7", body = "Body 7"),
    MyMessage(title = "Titulo 8", body = "Body 8"),
    MyMessage(title = "Titulo 9", body = "Body 9"),
    MyMessage(title = "Titulo 10", body = "Body 10"),
)

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice3Theme {
                MyMessages(messages)
            }
        }
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    Row(
        Modifier
            .background(MaterialTheme.colors.background)
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.logo), contentDescription = "Jorge Pilo Logo",
        Modifier
            .size(100.dp)
            .clip(CircleShape)
    )
}

@Composable
fun MyTexts(message: MyMessage) {
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        MyText(message.title, MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun MyText(text: String, color: Color, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, maxLines = lines)
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MyComponent(message = message)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    Practice3Theme {
        Practice3Theme {
            MyMessages(messages)
        }
    }
}