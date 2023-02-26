package com.example.allkotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.lang.StringBuilder

class Form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val firstname = findViewById<EditText>(R.id.firstname)
        val lastname = findViewById<EditText>(R.id.lastname)
        val email = findViewById<EditText>(R.id.email)
        val phonenumber = findViewById<EditText>(R.id.phonenumber)
        val empDetails = findViewById<TextView>(R.id.empdetails)

//        Buttons
        val submitBtn = findViewById<Button>(R.id.submitbtn)
        val submitAnotherActBtn = findViewById<Button>(R.id.submitAnotherActbtn)
        val submitFragmentbtn = findViewById<Button>(R.id.submitFragmentbtn)

//        Gender Radio Group
        val genderRadioGrp = findViewById<RadioGroup>(R.id.genderradio)
        lateinit var selectedGenderRadioBtn: RadioButton
        lateinit var selectedGenderRadioBtnValue: String

//        Department Radio Group
        val deptRadioGrp = findViewById<RadioGroup>(R.id.deptradio)
        lateinit var selectedDepartmentRadioBtn: RadioButton
        lateinit var selectedDepartmentRadioBtnValue: String

//        Position Radio Group
        val positionRadioGrp = findViewById<RadioGroup>(R.id.positionradio)
        lateinit var selectedPositionRadioBtn: RadioButton
        lateinit var selectedPositionRadioBtnValue: String

//        Checkbox
        val javaCheckBox = findViewById<CheckBox>(R.id.java)
        val kotlinCheckBox = findViewById<CheckBox>(R.id.kotlin)
        val cppCheckBox = findViewById<CheckBox>(R.id.cpp)
        val springCheckBox = findViewById<CheckBox>(R.id.spring)
        val sqlCheckBox = findViewById<CheckBox>(R.id.sql)
        val reactCheckBox = findViewById<CheckBox>(R.id.react)

//        var javaValue: String? = null
//        var kotlinValue: String? = null
//        var cppValue: String? = null
//        var springValue: String? = null
//        var sqlValue: String? = null
//        var reactValue: String? = null

        submitBtn.setOnClickListener {
            val selectedGenderRadioButtonId = genderRadioGrp.checkedRadioButtonId
            val selectedDepartmentRadioButtonId = deptRadioGrp.checkedRadioButtonId
            val selectedPositionRadioButtonId = positionRadioGrp.checkedRadioButtonId

            if(selectedGenderRadioButtonId != -1){
                selectedGenderRadioBtn = findViewById(selectedGenderRadioButtonId)
                selectedGenderRadioBtnValue = selectedGenderRadioBtn.text.toString()
            }

            if(selectedDepartmentRadioButtonId != -1){
                selectedDepartmentRadioBtn = findViewById(selectedDepartmentRadioButtonId)
                selectedDepartmentRadioBtnValue = selectedDepartmentRadioBtn.text.toString()
            }

            if(selectedPositionRadioButtonId != -1){
                selectedPositionRadioBtn = findViewById(selectedPositionRadioButtonId)
                selectedPositionRadioBtnValue = selectedPositionRadioBtn.text.toString()
            }

            empDetails.text = "Full Name: "+firstname.text.toString() + " " +
                    lastname.text.toString() + "\nEmail: " + email.text.toString() +
                    "\nPhone Number: " + phonenumber.text.toString() +
                    "\nGender: " + selectedGenderRadioBtnValue +
                    "\nDepartment: " + selectedDepartmentRadioBtnValue +
                    "\nPosition: " + selectedPositionRadioBtnValue +
                    "\nLanguages Chosen: "

        }

        submitAnotherActBtn.setOnClickListener {
            val selectedGenderRadioButtonId = genderRadioGrp.checkedRadioButtonId
            val selectedDepartmentRadioButtonId = deptRadioGrp.checkedRadioButtonId
            val selectedPositionRadioButtonId = positionRadioGrp.checkedRadioButtonId

            if(selectedGenderRadioButtonId != -1){
                selectedGenderRadioBtn = findViewById(selectedGenderRadioButtonId)
                selectedGenderRadioBtnValue = selectedGenderRadioBtn.text.toString()
            }

            if(selectedDepartmentRadioButtonId != -1){
                selectedDepartmentRadioBtn = findViewById(selectedDepartmentRadioButtonId)
                selectedDepartmentRadioBtnValue = selectedDepartmentRadioBtn.text.toString()
            }

            if(selectedPositionRadioButtonId != -1){
                selectedPositionRadioBtn = findViewById(selectedPositionRadioButtonId)
                selectedPositionRadioBtnValue = selectedPositionRadioBtn.text.toString()
            }

//            empDetails.text = "Full Name: "+firstname.text.toString() + " " +
//                    lastname.text.toString() + "\nEmail: " + email.text.toString() +
//                    "\nPhone Number: " + phonenumber.text.toString() +
//                    "\nGender: " + selectedGenderRadioBtnValue +
//                    "\nDepartment: " + selectedDepartmentRadioBtnValue +
//                    "\nPosition: " + selectedPositionRadioBtnValue +
//                    "\nLanguages Chosen: "


            intent = Intent(this, FormData::class.java)

            intent.putExtra("firstName", firstname.text.toString())
            intent.putExtra("lastName", lastname.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("phoneNumber", phonenumber.text.toString())
            intent.putExtra("gender", selectedGenderRadioBtnValue)
            intent.putExtra("department", selectedDepartmentRadioBtnValue)
            intent.putExtra("position", selectedPositionRadioBtnValue)

            startActivity(intent)
        }

        submitFragmentbtn.setOnClickListener {

            val selectedGenderRadioButtonId = genderRadioGrp.checkedRadioButtonId
            val selectedDepartmentRadioButtonId = deptRadioGrp.checkedRadioButtonId
            val selectedPositionRadioButtonId = positionRadioGrp.checkedRadioButtonId

            if(selectedGenderRadioButtonId != -1){
                selectedGenderRadioBtn = findViewById(selectedGenderRadioButtonId)
                selectedGenderRadioBtnValue = selectedGenderRadioBtn.text.toString()
            }

            if(selectedDepartmentRadioButtonId != -1){
                selectedDepartmentRadioBtn = findViewById(selectedDepartmentRadioButtonId)
                selectedDepartmentRadioBtnValue = selectedDepartmentRadioBtn.text.toString()
            }

            if(selectedPositionRadioButtonId != -1){
                selectedPositionRadioBtn = findViewById(selectedPositionRadioButtonId)
                selectedPositionRadioBtnValue = selectedPositionRadioBtn.text.toString()
            }

            var fm : FragmentManager = supportFragmentManager
            var ft : FragmentTransaction = fm.beginTransaction()
            var formFragment = FormFragment()

            var bundle = Bundle()
            bundle.putString("firstName", firstname.text.toString())
            bundle.putString("lastName", lastname.text.toString())
            bundle.putString("email", email.text.toString())
            bundle.putString("phoneNumber", phonenumber.text.toString())
            bundle.putString("gender", selectedGenderRadioBtnValue)
            bundle.putString("department", selectedDepartmentRadioBtnValue)
            bundle.putString("position", selectedPositionRadioBtnValue)
//
            formFragment.arguments = bundle
            ft.add(R.id.frameLayout, formFragment)
            ft.commit()
        }
    }
}