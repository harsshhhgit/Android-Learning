package com.example.datatransferactivityfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.textfield.TextInputEditText

class Frag2ActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_frag2_activity, container, false)

        var firstNameField = view.findViewById<TextInputEditText>(R.id.firstName)
        var lastNameField = view.findViewById<TextInputEditText>(R.id.lastName)
        var submitBtn = view.findViewById<Button>(R.id.submitButton)
        var submitBtnFrag = view.findViewById<Button>(R.id.submitButtonFrag)

        submitBtn.setOnClickListener {
            (activity as MainActivity).takeData(firstNameField.text.toString(), lastNameField.text.toString())
        }
        submitBtnFrag.setOnClickListener {

            var fm : FragmentManager = requireActivity().supportFragmentManager
            var ft : FragmentTransaction = fm.beginTransaction()
            var f2f = Fragment2Fragment()

            var bundle = Bundle()
            bundle.putString("firstName", firstNameField.text.toString())
            bundle.putString("lastName", lastNameField.text.toString())
            f2f.arguments = bundle
            ft.add(R.id.frameLayoutfrag2, f2f)
            ft.commit()
        }
        return view
    }

}