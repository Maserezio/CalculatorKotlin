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
        val graph: GraphView = binding.graph
        graph.viewport.setScalable(true)

        build.setOnClickListener {
            val series: LineGraphSeries<DataPoint> = LineGraphSeries<DataPoint>()
            var x: Double = -50.0;
            for (i in 0..10000) {
                x += 0.01
                series.appendData(
                    DataPoint
                        (
                        x,
                        ExpressionBuilder(input.text.toString()).variable("x").build()
                            .setVariable("x", x).evaluate()
                    ),
                    true,
                    50000
                )
            }
            graph.addSeries(series)
        }

        clear.setOnClickListener { graph.removeAllSeries()  }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}