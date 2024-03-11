package io.opentelemetry.example.bb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.opentelemetry.example.bb.ui.theme.BackpackingBuddyTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackpackingBuddyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Row(
                            Modifier.padding(all = 20.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("Backpacking Buddy")
                        }
                        Distance()
                        Elevation()
                        Disposition()
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun Disposition() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        TextButton(onClick = {}) {
            Text(text = "\uD83D\uDE0A", fontSize = 75.sp)
        }
        TextButton(onClick = {}) {
            Text(text = "\uD83D\uDE10", fontSize = 75.sp)
        }
        TextButton(onClick = {}) {
            Text(text = "☹\uFE0F", fontSize = 75.sp)
        }
    }
}


