package com.example.calculator.ui.standart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.databinding.StandartCalculatorBinding
import kotlinx.android.synthetic.main.standart_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder

class StandartCalculatorFragment : Fragment() {

    private lateinit var standartCalculatorModel: StandartCalculatorModel
    private var _binding: StandartCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        standartCalculatorModel = ViewModelProvider(this).get(StandartCalculatorModel::class.java)

        _binding = StandartCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        zero.setOnClickListener{ setFieldText("0") }
        one.setOnClickListener{ setFieldText("1") }
        two.setOnClickListener{ setFieldText("2") }
        three.setOnClickListener{ setFieldText("3") }
        four.setOnClickListener{ setFieldText("4") }
        five.setOnClickListener{ setFieldText("5") }
        six.setOnClickListener{ setFieldText("6") }
        seven.setOnClickListener{ setFieldText("7") }
        eight.setOnClickListener{ setFieldText("8") }
        nine.setOnClickListener{ setFieldText("9") }
        l_bracket.setOnClickListener{ setFieldText("(") }
        r_bracket.setOnClickListener{ setFieldText(")") }
        divide.setOnClickListener{ setFieldText("/") }
        multiply.setOnClickListener{ setFieldText("*") }
        minus.setOnClickListener{ setFieldText("-") }
        plus.setOnClickListener{ setFieldText("+") }
        dot.setOnClickListener{ setFieldText(".") }

        all_clear.setOnClickListener{ line.setText("") }
        backspace.setOnClickListener {
            val str = line.text.toString()
            if(str.isNotEmpty()){
                line.text = str.substring(0, str.length-1)
            }
        }
        equals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(line.text.toString()).build()
                line.text = ex.evaluate().toString()

            } catch (e:Exception) {
                Log.d("error:", e.message.toString())

            }
        }
    }

    private fun setFieldText(str: String)
    {
            line.append(str)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}