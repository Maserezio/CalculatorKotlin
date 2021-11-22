package com.example.calculator

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.graph_input.*
import com.google.android.material.bottomsheet.BottomSheetBehavior

import androidx.annotation.NonNull
import com.google.android.material.bottomsheet.BottomSheetDialog


class GraphInput : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.graph_input, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            close.setOnClickListener { dismiss() }
            add.setOnClickListener {
                val kek:EditText = EditText(this.context)
                kek.setText("y=")
                kekek.addView(kek)
            }
    }
}