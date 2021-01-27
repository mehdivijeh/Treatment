package com.eandm.treatment.utils

import android.annotation.SuppressLint
import java.lang.Exception
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun Date.today(): String {
    val dateFormat: DateFormat = SimpleDateFormat("yyyy/MM/dd")
    val date = Date()
    return dateFormat.format(date)
}

fun Date.dateTimeToGregorian(): String {
    return try {
        val format = "yyyy-MM-dd HH:mm:ss"
        val simpleDate = SimpleDateFormat(format, Locale("en"))
        simpleDate.format(this)
    }catch (e: Exception) {
        ""
    }
}


fun Date.dateToGregorian(): String {
    return try {
        val format = "yyyy-MM-dd"
        val simpleDate = SimpleDateFormat(format, Locale("en"))
        simpleDate.format(this)
    }catch (e: Exception) {
        ""
    }
}