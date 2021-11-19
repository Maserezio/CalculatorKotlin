package com.example.calculator.ui.engineer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.databinding.EngineerCalculatorBinding
import kotlinx.android.synthetic.main.engineer_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.operator.Operator
import net.objecthunter.exp4j.function.Function


class EngineerCalculatorFragment : Fragment() {

    private lateinit var engineerCalculatorModel: EngineerCalculatorModel
    private var _binding: EngineerCalculatorBinding? = null

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ezero.setOnClickListener{ setFieldText("0") }
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
        all_clear.setOnClickListener{ eline.setText("") }
        sin.setOnClickListener { setFieldText("sin(") }
        cos.setOnClickListener { setFieldText("cos(") }
        tan.setOnClickListener { setFieldText("tan(") }
        e.setOnClickListener { setFieldText("e") }
        ln.setOnClickListener { setFieldText("ln(") }
        log.setOnClickListener { setFieldText("log(") }
        percent.setOnClickListener { setFieldText("%") }
        sqrt.setOnClickListener { setFieldText("sqrt(") }
        pi.setOnClickListener { setFieldText("π") }
        exp.setOnClickListener { setFieldText("^") }
        factorial.setOnClickListener { setFieldText("!") }
        backspace.setOnClickListener {
            val str = eline.text.toString()
            if(str.isNotEmpty()){
                eline.text = str.substring(0, str.length-1)
            }
        }

        val factorial: Operator = object :
            Operator(
                "!",
                1,
                true,
                PRECEDENCE_POWER + 1
            ) {
            override fun apply(vararg args: Double): Double {
                val arg = args[0].toInt()
                require(arg.toDouble() == args[0]) //{ "Operand for factorial has to be an integer" }
                require(arg >= 0) //{ "The operand of the factorial can not be less than zero" }
                var result = 1.0
                for (i in 1..arg) {
                    result *= i.toDouble()
                }
                return result
            }
        }
        val ln: Function = object: Function("ln", 1) {
            override  fun apply(vararg args: Double): Double {
                return 2.303 * Math.log10(args[0])
            }
        }
        equals.setOnClickListener {
            try {




                val ex = ExpressionBuilder(eline.text.toString()).operator(factorial).function(ln).build()
                eline.text = ex.evaluate().toString()

            } catch (e:Exception) {
                Log.d("error:", e.message.toString())

            }
        }
    }

    private fun setFieldText(str: String)
    {
        eline.append(str)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}