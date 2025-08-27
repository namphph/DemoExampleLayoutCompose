package com.amazon.examplelayout

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amazon.examplelayout.ui.theme.ExampleLayoutTheme
import com.amazon.examplelayout.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ArtistCardArrange()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ArtistCard() {
    Text(text = "Artist Card 1")
    Text(text = "2 Card Artist")
}

@Composable
fun ArtistCardColumn() {
    Column {
        Text(text = "Artist Card 1", modifier = Modifier.padding(12.dp))
        Text(text = "2 Card Artist")
    }
}

@Composable
fun ArtistCardRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(Icons.Default.Person, contentDescription = "")
        Column {
            Text(text = "Pham Nam")
            Text(text = "26 age")
        }
    }
}

@Composable
fun ArtistAvatar() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(50.dp)) {
        Image(Icons.Default.AccountCircle, contentDescription = "Artist image")
        Icon(Icons.Filled.Check, contentDescription = "Check mark")
    }
}

@Composable
fun ArtistCardArrange() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = 30.dp)
            .background(Purple80)
    ) {
        Text(text = "HELLO")
        Text("LLLLL")
    }
}

@Preview
@Composable
fun ArtistCardRowPreview() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
        Image(Icons.Default.Person, contentDescription = "")
        Column {
            Text(text = "Pham Nam")
            Text(text = "26 age")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExampleLayoutTheme {
        Greeting("Android")
    }
}
