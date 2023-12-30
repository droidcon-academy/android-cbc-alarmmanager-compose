package com.droidcon.alarmmanager.ui.main

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.droidcon.alarmmanager.R
import com.droidcon.alarmmanager.helper.AlarmManagerHelper
import com.droidcon.alarmmanager.model.ScheduledAlarmItem
import com.droidcon.alarmmanager.ui.main.composables.AlarmButtons
import com.droidcon.alarmmanager.ui.main.composables.MessageTextField
import com.droidcon.alarmmanager.ui.main.composables.TimeInput
import com.droidcon.alarmmanager.ui.main.composables.toLocalDateTime
import com.droidcon.alarmmanager.ui.theme.AlarmManagerTheme

class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Toast.makeText(
                this,
                R.string.notification_granted,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                this,
                R.string.permission_required,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            AlarmManagerTheme(dynamicColor = false) {
                var messageText by remember { mutableStateOf("") }
                val state = rememberTimePickerState()

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TimeInput(state)

                    MessageTextField(messageText) { messageText = it }

                    Spacer(modifier = Modifier.height(8.dp))

                    AlarmButtons(
                        onClickSchedule = {

                        },
                        onClickCancel = {

                        }
                    )
                }
            }
        }

        askNotificationPermission()
    }

    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Directly ask for the permission
                requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
}
