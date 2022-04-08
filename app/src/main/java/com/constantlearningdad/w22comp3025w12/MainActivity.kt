package com.constantlearningdad.w22comp3025w12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.constantlearningdad.w22comp3025w12.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Only doing this to define some "default" students' in the Firestore database
//        var student1 = Student(20001, "Fred Flintstone", HashMap())
//        var student2 = Student(20002, "Wilma Flintstone", HashMap())
//        var student3 = Student(20003, "Pebbles Flintstone", HashMap())
//        var student4 = Student(20004, "Barney Rubble", HashMap())
//        var student5 = Student(20005, "Betty Rubble", HashMap())
//
//        student1.addGrade("COMP1030", 95)
//        student1.addGrade("COMP1008", 96)
//        student1.addGrade("COMP1011", 98)
//        student1.addGrade("COMP3025", 100)
//
//        student2.addGrade("COMP1030", 89)
//        student2.addGrade("COMP1008", 99)
//        student2.addGrade("COMP1011", 99)
//        student2.addGrade("COMP3025", 96)
//
//        student3.addGrade("COMP1030", 76)
//        student3.addGrade("COMP1008", 79)
//        student3.addGrade("COMP1011", 99)
//        student3.addGrade("COMP3025", 97)
//
//        student4.addGrade("COMP1030", 55)
//        student4.addGrade("COMP1008", 58)
//        student4.addGrade("COMP1011", 61)
//        student4.addGrade("COMP3025", 80)
//
//        student5.addGrade("COMP1030", 6)
//        student5.addGrade("COMP1008", 68)
//        student5.addGrade("COMP1011", 78)
//        student5.addGrade("COMP3025", 80)
//
//        //this will create a connection firestore and store the students
//        val db = FirebaseFirestore.getInstance().collection("students")
//
//        db.document().set(student1)
//        db.document().set(student2)
//        db.document().set(student3)
//        db.document().set(student4)
//        db.document().set(student5)

        val viewModel : StudentViewModel by viewModels()
        viewModel.getStudents().observe(this, {students ->
            binding.recyclerView.adapter = StudentAdapter(this, students)
        })
    }
}