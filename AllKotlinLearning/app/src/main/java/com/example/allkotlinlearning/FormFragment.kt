package com.example.allkotlinlearning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_form, container, false)
        var data = view.findViewById<TextView>(R.id.fragTextView)
        data.text = "Full Name: "+ arguments?.getString("firstName") + " " +
                arguments?.getString("lastName") + "\nEmail: " + arguments?.getString("email") +
                "\nPhone Number: " + arguments?.getString("phoneNumber") +
                "\nGender: " + arguments?.getString("gender") +
                "\nDepartment: " + arguments?.getString("department") +
                "\nPosition: " + arguments?.getString("position") +
                "\nLanguages Chosen: "

        return view
    }

}