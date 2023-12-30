package com.droidcon.alarmmanager.helper

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.droidcon.alarmmanager.model.ScheduledAlarmItem
import com.droidcon.alarmmanager.receivers.AlarmReceiver
import java.time.ZoneId

class AlarmManagerHelper(
    private val context: Context
) {  
    // ...
    
    fun cancel(alarmItem: ScheduledAlarmItem) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                alarmItem.hashCode(),
                Intent(context, AlarmReceiver::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }
}