package com.droidcon.alarmmanager.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.droidcon.alarmmanager.model.ScheduledAlarmItem
import com.droidcon.alarmmanager.helper.AlarmManagerHelper
import java.time.LocalDateTime

class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

    }
}