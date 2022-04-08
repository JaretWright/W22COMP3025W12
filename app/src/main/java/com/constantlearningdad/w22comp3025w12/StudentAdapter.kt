package com.constantlearningdad.w22comp3025w12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val context : Context,
                     val students : List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    /**
     * This class is used to allow us to connect/access the elements in the
     * item_project layout file
     */
    inner class StudentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val studentNumTextView = itemView.findViewById<TextView>(R.id.studentNumTextView)
        val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        val avgGradeTextView = itemView.findViewById<TextView>(R.id.averageGradeTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: StudentViewHolder, position: Int) {
        val student = students[position]
        with(viewHolder){
            studentNumTextView.text = student.studentNum.toString()
            nameTextView.text = student.fullName

            val avgGrade = student.getAvgGrade()

            if (avgGrade.isPresent)
                avgGradeTextView.text = String.format("Average Grade is %.1f%%",avgGrade.asDouble)
            else
                avgGradeTextView.text = "No grades registered yet"
            }
    }

    override fun getItemCount(): Int {
        return students.size
    }
}