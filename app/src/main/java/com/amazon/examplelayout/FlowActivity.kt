package com.amazon.examplelayout

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amazon.examplelayout.ui.theme.ExampleLayoutTheme

class FlowActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    flowColoumn()
                }
            }
        }
    }
}

@Composable
fun flowLayout(){
    FlowRow(modifier = Modifier.fillMaxSize().padding(8.dp), horizontalArrangement = Arrangement.End) {
        Text(text = "Flow 1")
        Text(text = "Flow 2")
        Text(text = "Flow 3")
        Text(text = "Flow 4")
        Text(text = "Flow 5")
        Text(text = "Flow 6")
        Text(text = "Flow 7")
        Text(text = "Flow 8")
        Text(text = "Flow 9")
        Text(text = "Flow 10")
        Text(text = "Flow 11")
        Text(text = "Flow 12")
        Text(text = "Flow 13")
        Text(text = "Flow 14")
    }
}

@Composable
fun flowColoumn(){
    FlowColumn(modifier = Modifier.fillMaxSize().padding(8.dp), verticalArrangement = Arrangement.Bottom){
        Text(text = "Flow 1")
        Text(text = "Flow 2")
        Text(text = "Flow 3")
        Text(text = "Flow 4")
        Text(text = "Flow 5")
        Text(text = "Flow 6")
        Text(text = "Flow 7")
        Text(text = "Flow 8")
        Text(text = "Flow 9")
        Text(text = "Flow 10")
        Text(text = "Flow 11")
        Text(text = "Flow 12")
        Text(text = "Flow 13")
        Text(text = "Flow 14")
    }
}
