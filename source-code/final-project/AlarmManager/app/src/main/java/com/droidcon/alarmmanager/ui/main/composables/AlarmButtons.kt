package com.droidcon.alarmmanager.ui.main.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlarmButtons(
    onClickSchedule: () -> Unit,
    onClickCancel: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = onClickSchedule) {
            Text(text = "Schedule")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onClickCancel) {
            Text(text = "Cancel")
        }
        Spacer(modifier = Modifier.width(8.dp))
    }
}