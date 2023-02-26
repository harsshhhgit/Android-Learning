package com.example.datatransferactivityfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragment2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_fragment2, container, false)

        var data = view.findViewById<TextView>(R.id.textViewFrag2Frag)
        data.text = "Full Name: "+ arguments?.getString("firstName") + " " +
                arguments?.getString("lastName")


        return view
    }
}