package com.alekseytyan.convertions

import java.text.SimpleDateFormat

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val format = SimpleDateFormat("yyyy-MM-dd");
        val date1 = format.parse("$year-$month-$dayOfMonth")
        val date2 = format.parse("${other.year}-${other.month}-${other.dayOfMonth}")

        return date1.compareTo(date2)
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}