package com.dicoding.moviecatalogue.utils

import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun dateConvert(D: String): String {
        val format1 = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val format2 = SimpleDateFormat("dd-MMMM-yyyy", Locale.getDefault())
        var date: Date? = null
        try {
            date = format1.parse(D)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        var dateString: String = format2.format(date)
        dateString = dateString.replace("-", " ")
        return dateString
    }

    fun removeDecimal(decimal:Double): String{
        val df = DecimalFormat("###")
        return df.format(decimal)
    }
}