package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calculator.databinding.GraphingCalculatorBinding
import com.jjoe64.graphview.series.*
import com.jjoe64.graphview.GraphView
import kotlinx.android.synthetic.main.graphing_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder





class GraphingCalculatorFragment : Fragment() {

    private var _binding: GraphingCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GraphingCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val graph:GraphView = binding.graph
        graph.getViewport().setScalable(true)



//        val series: LineGraphSeries<DataPoint> = LineGraphSeries<DataPoint>()
//
//        var x : Double = 0.0;
//        var y : Double = 0.0
//        x = -50.0
//
//        for (i in 0..500)
//        {
//            x += 0.1
//            y = (input.text).toString().toDouble()
//            series.appendData(DataPoint(x,y), true, 5000)
//        }
//
//        graph.addSeries(series)



        val series = LineGraphSeries(
            arrayOf<DataPoint>(
                DataPoint(0.0, ExpressionBuilder("sin(x)").variable("x").build().setVariable("x", 0.0).evaluate().toDouble()),
                DataPoint(1.0, ExpressionBuilder("sin(x)").variable("x").build().setVariable("x", 1.0).evaluate().toDouble()),
                DataPoint(2.0, ExpressionBuilder("sin(x)").variable("x").build().setVariable("x", 2.0).evaluate().toDouble()),
                DataPoint(3.0, ExpressionBuilder("sin(x)").variable("x").build().setVariable("x", 3.0).evaluate().toDouble()),
                DataPoint(4.0, ExpressionBuilder("sin(x)").variable("x").build().setVariable("x", 4.0).evaluate().toDouble() )
            )
        )
        graph.addSeries(series)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}