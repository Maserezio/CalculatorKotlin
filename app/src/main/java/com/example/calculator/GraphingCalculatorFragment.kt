package com.example.calculator

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.calculator.databinding.GraphingCalculatorBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jjoe64.graphview.series.*
import com.jjoe64.graphview.GraphView
import kotlinx.android.synthetic.main.graphing_calculator.*


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
        val add = GraphInput()

        button3.setOnClickListener {
            add.show(childFragmentManager,"bebra")
        }

//        val graph:GraphView = binding.graph
//        graph.getViewport().setScalable(true)
//
//        val Data = intArrayOf(
//            10, 46, 53, 58, 63, 67, 69, 72, 75, 78, 82, 85,
//            90, 95, 99, 105, 110, 115, 121, 126, 132, 137, 143,
//            148, 153, 157, 162, 165, 168, 170, 173, 174, 175, 176,
//            177, 177, 177, 176, 176, 175, 173, 172, 171, 169, 168,
//            167, 166, 164, 161, 155, 147, 136, 123, 111, 101, 92, 84,
//            78, 74, 70, 67, 65, 64, 62, 61, 61, 60, 60, 59, 59, 58, 58,
//            58, 57, 57, 57, 56, 56, 56, 56, 56, 56, 56, 55, 55, 55, 55,
//            55, 54, 54
//        )
//
//        val series: LineGraphSeries<DataPoint> = LineGraphSeries<DataPoint>()
//
//        var x : Double = 0.0;  var y : Double = 0.0
//        x = -50.0
//
//        for (i in -100..500)
//        {
//            x += 0.1
//            y = Math.sin(x)
//            series.appendData(DataPoint(x,y), true, 5000)
//        }

        //graph.addSeries(series)


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}