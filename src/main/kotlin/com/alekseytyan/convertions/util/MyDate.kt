package com.alekseytyan.convertions.util

import com.alekseytyan.convertions.DateRange
import com.alekseytyan.convertions.TimeInterval
import java.text.SimpleDateFormat
import java.util.Calendar

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val format = SimpleDateFormat("yyyy-MM-dd");
        val date1 = format.parse("$year-$month-$dayOfMonth")
        val date2 = format.parse("${other.year}-${other.month}-${other.dayOfMonth}")

        return date1.compareTo(date2)
    }
}

/*
 * Returns the following date after the given one.
 * For example, for Dec 31, 2019 the date Jan 1, 2020 is returned.
 */
fun MyDate.followingDate(): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    val millisecondsInADay = 24 * 60 * 60 * 1000L
    val timeInMillis = c.timeInMillis + millisecondsInADay
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, amount: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year + if(timeInterval == TimeInterval.YEAR) amount else 0, month, dayOfMonth)
    var timeInMillis = c.timeInMillis
    val millisecondsInADay = 24 * 60 * 60 * 1000L
    timeInMillis += amount * when (timeInterval) {
        TimeInterval.DAY -> millisecondsInADay
        TimeInterval.WEEK -> 7 * millisecondsInADay
        TimeInterval.YEAR -> 0L
    }

    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}

