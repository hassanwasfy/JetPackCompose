package com.example.jetpackcompose.screens.task.two

data class Day(val dayNumber: Int, val dayName: String)
class Days {
    fun generateMonthDays(totalDaysInMonth: Int, startingDayName: String): List<Day> {
        val daysList = mutableListOf<Day>()

        val dayNames = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

        val startingDayIndex = dayNames.indexOf(startingDayName)

        for (dayNumber in 1..totalDaysInMonth) {
            val dayNameIndex = (startingDayIndex + dayNumber - 1) % 7
            val dayName = dayNames[dayNameIndex]
            daysList.add(Day(dayNumber, dayName))
        }

        return daysList
    }

    fun timeList(): List<String> {
        return listOf("10:00", "12:30", "15:30", "18:00", "21:00", "12:00")
    }
}