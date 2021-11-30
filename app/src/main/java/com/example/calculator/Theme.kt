package com.example.calculator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.theme.*


class Theme : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.theme, container, false)

        return rootView
    }

    //TODO:theme switch

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close_opt.setOnClickListener {
            dismiss()
        }

        apply_opt.setOnClickListener {
            val toast = Toast.makeText(view.context, "Theme", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}