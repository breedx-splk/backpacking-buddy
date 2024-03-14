package io.opentelemetry.example.bb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CoordinatesViewModel : ViewModel() {
    val distanceState = MutableStateFlow("0.0")
    val elevationState = MutableStateFlow("0.0")
    private var distance = 0f
    private var elevation = 0f

    init {
        viewModelScope.launch {
            while (true) {
                delay(500)
                updateDistance()
            }
        }
        viewModelScope.launch {
            delay(1000)
            while (true) {
                delay(500)
                updateElevation()
            }
        }
    }

    private fun updateDistance() {
        distance += 0.003f
        distanceState.value = String.format("%.2f", distance)
    }

    private fun updateElevation() {
        elevation += 0.005f
        elevationState.value = String.format("%.2f", elevation)
    }
}