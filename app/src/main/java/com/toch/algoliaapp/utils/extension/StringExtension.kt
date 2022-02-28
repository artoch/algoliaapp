package com.toch.algoliaapp.utils.extension

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import android.text.format.DateUtils
import com.toch.algoliaapp.utils.EMPTY_STRING
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
fun String.dateToMinutes(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    sdf.timeZone = TimeZone.getTimeZone("GMT")
    try {
        val time: Long? = sdf.parse(this)?.time
        time?.let {
            val now = System.currentTimeMillis()
            val ago = DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS)
            return ago.toString()
        }
        return EMPTY_STRING
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return EMPTY_STRING
}