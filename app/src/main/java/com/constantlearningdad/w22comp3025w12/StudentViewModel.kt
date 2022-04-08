package com.constantlearningdad.w22comp3025w12

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class StudentViewModel : ViewModel(){
    private val students = MutableLiveData<List<Student>>()

    /**
     * This returns a list of Student objects as "LiveData" so changes in Firestore will be pushed
     * to the application
     */
    fun getStudents() : LiveData<List<Student>>
    {
        return students
    }

    /**
     * When the class is first instantiated, it calls the init method
     */
    init{
        FirebaseFirestore.getInstance().collection("students")
            .orderBy("studentNum")
            .addSnapshotListener{ documents, exception ->
                if (exception != null)
                {
                    Log.w("DB", "Listen failed ${exception.code}")
                    return@addSnapshotListener
                }

                //loop over the student documents and covert them to be student objects
                documents?.let {
                    val studentList = ArrayList<Student>()

                    for(document in documents)
                    {
                        val student = document.toObject(Student::class.java)
                        studentList.add(student)
                    }

                    students.value = studentList
                }
            }
    }
}