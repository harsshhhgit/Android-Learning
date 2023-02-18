package com.example.twoactivityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val firstname = findViewById<EditText>(R.id.firstname)
        val lastname = findViewById<EditText>(R.id.lastname)
        val email = findViewById<EditText>(R.id.email)
        val phonenumber = findViewById<EditText>(R.id.phonenumber)
        val submitBtn = findViewById<Button>(R.id.submitbtn)
        val empDetails = findViewById<TextView>(R.id.empdetails)

//      Gender Radio Group
        val genderRadioGrp = findViewById<RadioGroup>(R.id.genderradio)
        lateinit var selectedGenderRadioBtn: RadioButton
        lateinit var selectedGenderRadioBtnValue: Any
/*        val genderMale = findViewById<RadioButton>(R.id.radiomale)
        val genderFemale = findViewById<RadioButton>(R.id.radiofemale)  */

//      Department Radio Group
        val deptRadioGrp = findViewById<RadioGroup>(R.id.deptradio)
        lateinit var selectedDepartmentRadioBtn: RadioButton
        lateinit var selectedDepartmentRadioBtnValue: Any
/*        val deptIT = findViewById<RadioButton>(R.id.radioit)
        val deptFinance = findViewById<RadioButton>(R.id.radiofinance)
        val deptuiux = findViewById<RadioButton>(R.id.radiouiux)  */

//      Position Radio Group
        val positionRadioGrp = findViewById<RadioGroup>(R.id.positionradio)
        lateinit var selectedPositionRadioBtn: RadioButton
        lateinit var selectedPositionRadioBtnValue: Any
/*        val positionSenior = findViewById<RadioButton>(R.id.radiosenior)
        val positionJunior = findViewById<RadioButton>(R.id.radiojunior)
        val positionNewbie = findViewById<RadioButton>(R.id.radionewbie)  */

//        Checkbox
        val javaCheckBox = findViewById<CheckBox>(R.id.java)
        val kotlinCheckBox = findViewById<CheckBox>(R.id.kotlin)
        val cppCheckBox = findViewById<CheckBox>(R.id.cpp)
        val springCheckBox = findViewById<CheckBox>(R.id.spring)
        val sqlCheckBox = findViewById<CheckBox>(R.id.sql)
        val reactCheckBox = findViewById<CheckBox>(R.id.react)
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
                    "\nPosition: " + selectedPositionRadioBtnValue

        }
    }
}