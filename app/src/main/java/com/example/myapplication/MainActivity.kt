package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity(), MenuClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val buttonsFragment = ButtonsFragment()
            supportFragmentManager.beginTransaction().replace(
                R.id.fragmentContainer, buttonsFragment
            ).commit()
        }
    }

    override fun onCalculatorClick() {
        val bundle = Bundle()
        val calculatorFragment = CalculatorFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, calculatorFragment)
        transaction.commit()
        transaction.addToBackStack(null)
    }

    override fun onExitClick() {
        exitProcess(-1)
    }
}
