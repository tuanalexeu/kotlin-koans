package com.alekseytyan.introduction

fun joinOptions(options: Collection<String>) =
    options.joinToString(", ","[", "]")