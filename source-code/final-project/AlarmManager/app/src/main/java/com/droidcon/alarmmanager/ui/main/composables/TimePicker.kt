package com.droidcon.alarmmanager.ui.main.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeInput(state: TimePickerState) {
    TimeInput(
        state = state,
        modifier = Modifier.padding(16.dp),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TimeInputPreview() {
    TimeInput(rememberTimePickerState())
}

@OptIn(ExperimentalMaterial3Api::class)
fun TimePickerState.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.of(
        LocalDateTime.now().toLocalDate(),
        LocalTime.of(this.hour, this.minute)
    )
}
