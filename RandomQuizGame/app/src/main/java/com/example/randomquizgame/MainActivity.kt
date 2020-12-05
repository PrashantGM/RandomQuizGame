package com.example.randomquizgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnFirst:Button
    private lateinit var btnSecond:Button
    private lateinit var tvResult:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btnFirst=findViewById(R.id.btnFirst)
        btnSecond=findViewById(R.id.btnSecond)
        tvResult=findViewById(R.id.tvResult)
        var count=0
        while(count<10)
        {
            if(count==0)
            {
                val rand2=secondRand()
                val rand1=firstRand()
                btnFirst.setText(rand1)
                btnSecond.setText(rand2)
            }

                btnFirst.setOnClickListener {
                    val other = btnSecond.text.toString().toInt()
                    val userInput = btnFirst.text.toString().toInt()

                    if (userInput > other) {

                        resultcalc(1);
                    }
                    val rand1 = firstRand()
                    val rand2 = secondRand()
                    btnFirst.setText(rand1)
                    btnSecond.setText(rand2)

                }
                btnSecond.setOnClickListener {

                    val other = btnFirst.text.toString().toInt()
                    val userInput = btnSecond.text.toString().toInt()
                    if (userInput > other) {
                        resultcalc(1);
                    }
                    val rand1 = firstRand()
                    val rand2 = secondRand()
                    btnFirst.setText(rand1)
                    btnSecond.setText(rand2)
                }

            count++
        }


    }
    private fun resultcalc(cans:Int){
        var correct=0
        correct=correct+cans
        tvResult.setText("Correct Answers: $correct")
    }
    private fun firstRand():Int{
        val rand1=(0..100).random()
        btnFirst.setText(rand1)
        return rand1

    }
    private fun secondRand():Int{
        val rand2=(0..100).random()
        btnSecond.setText(rand2)
        return rand2
    }
}