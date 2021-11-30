package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calculator.databinding.StandardCalculatorBinding
import kotlinx.android.synthetic.main.standard_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder

class StandardCalculatorFragment : Fragment() {

    private var _binding: StandardCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = StandardCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        zero.setOnClickListener {
            setFieldText("0")
            scroll_line.scrollTo(line.right, 0)
        }
        one.setOnClickListener {
            setFieldText("1")
            scroll_line.scrollTo(line.right, 0)
        }
        two.setOnClickListener {
            setFieldText("2")
            scroll_line.scrollTo(line.right, 0)
        }
        three.setOnClickListener {
            setFieldText("3")
            scroll_line.scrollTo(line.right, 0)
        }
        four.setOnClickListener {
            setFieldText("4")
            scroll_line.scrollTo(line.right, 0)
        }
        five.setOnClickListener {
            setFieldText("5")
            scroll_line.scrollTo(line.right, 0)
        }
        six.setOnClickListener {
            setFieldText("6")
            scroll_line.scrollTo(line.right, 0)
        }
        seven.setOnClickListener {
            setFieldText("7")
            scroll_line.scrollTo(line.right, 0)
        }
        eight.setOnClickListener {
            setFieldText("8")
            scroll_line.scrollTo(line.right, 0)
        }
        nine.setOnClickListener {
            setFieldText("9")
            scroll_line.scrollTo(line.right, 0)
        }

        l_bracket.setOnClickListener {
            setFieldText("(")
            scroll_line.scrollTo(line.right, 0)
        }
        r_bracket.setOnClickListener {
            setFieldText(")")
            scroll_line.scrollTo(line.right, 0)
        }
        divide.setOnClickListener {
            setFieldText("/")
            scroll_line.scrollTo(line.right, 0)
        }
        multiply.setOnClickListener {
            setFieldText("*")
            scroll_line.scrollTo(line.right, 0)
        }
        minus.setOnClickListener {
            setFieldText("-")
            scroll_line.scrollTo(line.right, 0)
        }
        plus.setOnClickListener {
            setFieldText("+")
            scroll_line.scrollTo(line.right, 0)
        }
        dot.setOnClickListener {
            setFieldText(".")
            scroll_line.scrollTo(line.right, 0)
        }

        all_clear.setOnClickListener { line.setText("") }
        backspace.setOnClickListener {

            val str = line.text.toString()
            if (str.isNotEmpty()) {
                line.text = str.substring(0, str.length - 1)
            }
        }
        equals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(line.text.toString()).build()
                line.text = if (ex.evaluate().toString().endsWith(".0")) ex.evaluate().toString()
                    .dropLast(2) else ex.evaluate().toString()

            } catch (e: Exception) {
                Log.d("error:", e.message.toString())

            }
        }
    }

    private fun setFieldText(str: String) {
        line.append(str)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}