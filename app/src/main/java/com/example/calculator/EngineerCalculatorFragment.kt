package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.calculator.databinding.EngineerCalculatorBinding
import kotlinx.android.synthetic.main.engineer_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.operator.Operator
import net.objecthunter.exp4j.function.Function
import kotlin.math.*


class EngineerCalculatorFragment : Fragment() {

    private var _binding: EngineerCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EngineerCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ezero.setOnClickListener {
            setFieldText("0")
            scroll_line.scrollTo(eline.right, 0)
        }

        one.setOnClickListener {
            setFieldText("1")
            scroll_line.scrollTo(eline.right, 0)
        }

        two.setOnClickListener {
            setFieldText("2")
            scroll_line.scrollTo(eline.right, 0)
        }

        three.setOnClickListener {
            setFieldText("3")
            scroll_line.scrollTo(eline.right, 0)
        }

        four.setOnClickListener {
            setFieldText("4")
            scroll_line.scrollTo(eline.right, 0)
        }

        five.setOnClickListener {
            setFieldText("5")
            scroll_line.scrollTo(eline.right, 0)
        }

        six.setOnClickListener {
            setFieldText("6")
            scroll_line.scrollTo(eline.right, 0)
        }

        seven.setOnClickListener {
            setFieldText("7")
            scroll_line.scrollTo(eline.right, 0)
        }

        eight.setOnClickListener {
            setFieldText("8")
            scroll_line.scrollTo(eline.right, 0)
        }

        nine.setOnClickListener {
            setFieldText("9")
            scroll_line.scrollTo(eline.right, 0)
        }

        l_bracket.setOnClickListener {
            setFieldText("(")
            scroll_line.scrollTo(eline.right, 0)
        }

        r_bracket.setOnClickListener {
            setFieldText(")")
            scroll_line.scrollTo(eline.right, 0)
        }

        divide.setOnClickListener {
            setFieldText("/")
            scroll_line.scrollTo(eline.right, 0)
        }

        multiply.setOnClickListener {
            setFieldText("*")
            scroll_line.scrollTo(eline.right, 0)
        }

        minus.setOnClickListener {
            setFieldText("-")
            scroll_line.scrollTo(eline.right, 0)
        }

        plus.setOnClickListener {
            setFieldText("+")
            scroll_line.scrollTo(eline.right, 0)
        }

        dot.setOnClickListener {
            setFieldText(".")
            scroll_line.scrollTo(eline.right, 0)
        }

        all_clear.setOnClickListener {
            eline.setText("")
        }

        sin.setOnClickListener {
            setFieldText("sin(")
            scroll_line.scrollTo(eline.right, 0)
        }

        cos.setOnClickListener {
            setFieldText("cos(")
            scroll_line.scrollTo(eline.right, 0)
        }

        tan.setOnClickListener {
            setFieldText("tan(")
            scroll_line.scrollTo(eline.right, 0)
        }

        e.setOnClickListener {
            setFieldText("e")
            scroll_line.scrollTo(eline.right, 0)
        }

        ln.setOnClickListener {
            setFieldText("ln(")
            scroll_line.scrollTo(eline.right, 0)
        }

        log.setOnClickListener {
            setFieldText("log(")
            scroll_line.scrollTo(eline.right, 0)
        }

        percent.setOnClickListener {
            setFieldText("%")
            scroll_line.scrollTo(eline.right, 0)
        }

        sqrt.setOnClickListener {
            setFieldText("sqrt(")
            scroll_line.scrollTo(eline.right, 0)
        }

        pi.setOnClickListener {
            setFieldText("π")
            scroll_line.scrollTo(eline.right, 0)
        }

        exp.setOnClickListener {
            setFieldText("^")
            scroll_line.scrollTo(eline.right, 0)
        }

        factorial.setOnClickListener {
            setFieldText("!")
            scroll_line.scrollTo(eline.right, 0)
        }

        degrad.setOnClickListener {
            if (degrad.text == "DEG") degrad.text = "RAD" else degrad.text = "DEG"
        }

        backspace.setOnClickListener {
            val str = eline.text.toString()
            if (str.isNotEmpty()) {
                eline.text = str.substring(0, str.length - 1)
            }
        }

        val factorial: Operator = object : Operator(
            "!",
            1,
            true,
            PRECEDENCE_POWER + 1
        ) {
            override fun apply(vararg args: Double): Double {
                val arg = args[0].toInt()
                require(arg.toDouble() == args[0])
                require(arg >= 0)
                var result = 1.0
                for (i in 1..arg) {
                    result *= i.toDouble()
                }
                return result
            }
        }
        val percent: Operator = object : Operator(
            "%",
            1,
            true,
            PRECEDENCE_POWER + 1
        ) {
            override fun apply(vararg args: Double): Double {
                return 0.01 * args[0]
            }
        }
        val ln: Function = object : Function("ln", 1) {
            override fun apply(vararg args: Double): Double {
                return 2.303 * log10(args[0])
            }
        }

        val dsin: Function = object : Function("sin", 1) {
            override fun apply(vararg args: Double): Double {
                return sin(args[0] / 57.29577951308)
            }
        }
        val dcos: Function = object : Function("cos", 1) {
            override fun apply(vararg args: Double): Double {
                return cos(args[0] / 57.29577951308)
            }
        }
        val dtan: Function = object : Function("tan", 1) {
            override fun apply(vararg args: Double): Double {
                return tan(args[0] / 57.29577951308)
            }
        }


        equals.setOnClickListener {
            try {

                if (degrad.text == "RAD") {
                    val ex = ExpressionBuilder(eline.text.toString())
                        .operator(factorial)
                        .operator(percent)
                        .function(ln)
                        .build()
                    eline.text =
                        if (ex.evaluate().toString().endsWith(".0")) ex.evaluate().toString()
                            .dropLast(2) else ex.evaluate().toString()
                } else {
                    val ex = ExpressionBuilder(eline.text.toString())
                        .operator(factorial)
                        .operator(percent)
                        .function(ln)
                        .function(dsin)
                        .function(dcos)
                        .function(dtan)
                        .build()
                    eline.text =
                        if (ex.evaluate().toString().endsWith(".0")) ex.evaluate().toString()
                            .dropLast(2) else ex.evaluate().toString()
                }
            } catch (e: Exception) {
                Log.d("error:", e.message.toString())
            }
        }
    }

    private fun setFieldText(str: String) {
        eline.append(str)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}