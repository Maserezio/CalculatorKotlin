package com.example.calculator.ui.engineer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.databinding.EngineerCalculatorBinding

class EngineerCalculatorFragment : Fragment() {

    private lateinit var engineerCalculatorModel: EngineerCalculatorModel
    private var _binding: EngineerCalculatorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        engineerCalculatorModel =
            ViewModelProvider(this).get(EngineerCalculatorModel::class.java)

        _binding = EngineerCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}