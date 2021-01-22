package com.eandm.treatment.utils

import android.annotation.SuppressLint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun Date.today(): String {
    val dateFormat: DateFormat = SimpleDateFormat("yyyy/MM/dd")
    val date = Date()
    return dateFormat.format(date)
}