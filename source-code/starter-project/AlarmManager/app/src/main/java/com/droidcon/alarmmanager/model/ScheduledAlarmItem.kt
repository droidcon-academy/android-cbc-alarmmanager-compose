package com.droidcon.alarmmanager.model

import java.time.LocalDateTime

data class ScheduledAlarmItem(
    val alarmTime : LocalDateTime,
    val message : String
)