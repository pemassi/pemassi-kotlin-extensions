package io.pemassi.kotlin.extensions.common

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun GetCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

fun StringToDate(dateString: String, format: String, locale: Locale = Locale.getDefault()): Date {
    val dateFormat = SimpleDateFormat(format, locale)
    dateFormat.isLenient = false
    return dateFormat.parse(dateString)
}

fun String.toLocalDate(format: String, locale: Locale = Locale.getDefault()): LocalDate {
    val dateFormat = DateTimeFormatter.ofPattern(format, locale)
    return LocalDate.parse(this, dateFormat)
}

fun LocalDate.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val dateFormat = DateTimeFormatter.ofPattern(format, locale)
    return this.format(dateFormat)
}

fun String.toLocalTime(format: String, locale: Locale = Locale.getDefault()): LocalTime {
    val dateFormat = DateTimeFormatter.ofPattern(format, locale)
    return LocalTime.parse(this, dateFormat)
}

fun LocalTime.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val dateFormat = DateTimeFormatter.ofPattern(format, locale)
    return this.format(dateFormat)
}

fun String.toLocalDateTime(format: String, locale: Locale = Locale.getDefault()): LocalDateTime {
    val dateFormat = DateTimeFormatter.ofPattern(format, locale)
    return LocalDateTime.parse(this, dateFormat)
}

fun LocalDateTime.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val dateFormat = DateTimeFormatter.ofPattern(format, locale)
    return this.format(dateFormat)
}