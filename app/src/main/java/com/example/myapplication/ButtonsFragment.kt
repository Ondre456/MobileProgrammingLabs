package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentButtonsBinding
import kotlin.system.exitProcess

class ButtonsFragment : Fragment() {
    private var binding: FragmentButtonsBinding? = null
    private var communicator: MenuClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MenuClickListener)
            communicator = context
    }
    override fun onDestroy() {
        super.onDestroy()
        communicator = null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buttons, container, false)
        communicator = activity as MenuClickListener
        binding = FragmentButtonsBinding.bind(view).apply {
            exitButton.setOnClickListener { exitProcess(-1) }
            calculatorButton.setOnClickListener {
                parentFragmentManager.popBackStack()
                communicator?.onCalculatorClick()
            }
        }
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }
}