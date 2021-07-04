package com.alekseytyan.convertions

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in first..last
}


fun MyDate.rangeTo(other: MyDate): Boolean {

}

fun MyDate.contains(other: MyDate): Boolean {

}