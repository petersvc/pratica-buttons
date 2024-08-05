package com.example.buttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttons.ui.theme.ButtonsTheme
import com.example.buttons.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Buttons(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Buttons(modifier: Modifier = Modifier) {
    val btnVisibility = remember {mutableStateOf(true)}
    Column (
        modifier
            .fillMaxSize()
            .padding(72.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly // Arrangement.spacedBy(72.dp)
    ) {
        if (btnVisibility.value) {
            FilledBtn{ /*TODO*/ }
            FilledTonalBtn { /*TODO*/ }
            ElevatedBtn { /* TODO */ }
        }

        OutlinedBtn{btnVisibility.value = !btnVisibility.value }
    }
}

@Composable
fun FilledBtn(onclick: () -> Unit) {
    Button(onClick = { onclick() }) {
        Text(text = "Filled Button", color = Color.White)
    }
}

@Composable
fun FilledTonalBtn(onclick: () -> Unit) {
    FilledTonalButton(onClick = { onclick() }) {
        Text(text = "Filled Tonal Button", color = Color.Black)
    }
}

@Composable
fun ElevatedBtn(onclick: () -> Unit) {
    ElevatedButton(onClick = { onclick() }) {
        Text(text = "Elevated Button")
    }
}

@Composable
fun OutlinedBtn(onclick: () -> Unit) {
    OutlinedButton(onClick = { onclick() }) {
        Text(text = "Outlined Button", color = Orange)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    ButtonsTheme {
        Buttons()
    }
}