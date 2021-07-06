package com.alekseytyan.convertions

import com.alekseytyan.convertions.util.MyDate

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in first..last
}