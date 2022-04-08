package com.constantlearningdad.w22comp3025w12

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.HashMap

class Student(
    var studentNum : Int? = null,
    var fullName : String? = null,
    var grades : HashMap<String, Int>? = null
) {

    /**
     * This method/function will add a course code and grade to the user
     */
    fun addGrade(courseCode : String, grade : Int){
        grades?.let {
            if (courseCode.isNotEmpty() && grade >=0 && grade <=100)
                it.put(courseCode, grade)
        }
    }

    /**
     * This method returns an optional double with the average grade of the student
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun getAvgGrade() : OptionalDouble{
        if (grades == null)
            grades = HashMap()

        var gradesOnly = grades!!.values

        return gradesOnly.stream()
            .mapToDouble(Int::toDouble)
            .average()
    }
}