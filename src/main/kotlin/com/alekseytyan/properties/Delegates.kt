package com.alekseytyan.properties

import com.alekseytyan.convertions.util.MyDate
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        TODO()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        TODO()
    }
}