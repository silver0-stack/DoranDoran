package com.swu.doran.calendar

data class Schedule(
    val name: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val location: String = "",
    val mention:String="",
    val alarm: String = ""
)
