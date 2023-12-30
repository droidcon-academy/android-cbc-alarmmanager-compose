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
        if (intent?.action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            context?.let {
                val alarmHelper = AlarmManagerHelper(it)
                alarmHelper.schedule(getPersistedAlarmItem())
                Log.d(BootCompletedReceiver::class.simpleName, "Alarm was reset")
            }
        }
    }

    // Simulate fetching persisted alarm
    private fun getPersistedAlarmItem(): ScheduledAlarmItem {
        return ScheduledAlarmItem(
            alarmTime = LocalDateTime.now()
                .plusSeconds(
                    5.toLong()
                ),
            message = "Alarm Reset After Reboot"
        )
    }
}