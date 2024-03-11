package io.opentelemetry.example.bb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Distance() {
    Row {
        Card(modifier = Modifier.size(width = 250.dp, height = 150.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(vertical = 25.dp), Arrangement.Center
            ) {
                CenterText(text = "Distance", fontSize = 20.sp)
                CenterText(text = "6.42", fontSize = 40.sp)
                CenterText(text = "kilometers", fontSize = 12.sp)
            }
        }
    }
}