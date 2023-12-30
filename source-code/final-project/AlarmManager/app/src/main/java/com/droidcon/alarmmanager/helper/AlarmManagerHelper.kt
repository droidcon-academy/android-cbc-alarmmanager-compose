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
    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    @SuppressLint("MissingPermission")
    fun schedule(item: ScheduledAlarmItem) {
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("EXTRA_MESSAGE", item.message)
        }
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            item.alarmTime.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000,
            PendingIntent.getBroadcast(
                context,
                item.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }

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