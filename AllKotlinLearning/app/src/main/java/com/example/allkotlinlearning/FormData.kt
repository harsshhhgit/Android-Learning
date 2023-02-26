package com.example.allkotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FormData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_data)

        val dataFromAct = findViewById<TextView>(R.id.dataFromAct)

//        dataFromAct.setText(intent.getStringExtra("firstName"))
//        dataFromAct.setText(intent.getStringExtra("lastName"))
//        dataFromAct.setText(intent.getStringExtra("email"))
//        dataFromAct.setText(intent.getStringExtra("phoneNumber"))
//        dataFromAct.setText(intent.getStringExtra("gender"))
//        dataFromAct.setText(intent.getStringExtra("department"))
//        dataFromAct.setText(intent.getStringExtra("position"))

        dataFromAct.text = "Full Name: "+ intent.getStringExtra("firstName") + " " +
                intent.getStringExtra("lastName") + "\nEmail: " + intent.getStringExtra("email") +
                    "\nPhone Number: " + intent.getStringExtra("phoneNumber") +
                    "\nGender: " + intent.getStringExtra("gender") +
                    "\nDepartment: " + intent.getStringExtra("department") +
                    "\nPosition: " + intent.getStringExtra("position") +
                    "\nLanguages Chosen: "
    }
}