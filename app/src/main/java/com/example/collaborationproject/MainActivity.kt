package com.example.collaborationproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.collaborationproject.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var numberA=0
    var numberB=0
    var counterLevel=1
    var score=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initViews()


    }

    private fun initViews() {
        setRandomNumber()
        setNumberButton()
        binding.buttonCube.setOnClickListener {
            setRandomNumber()
            setNumberButton()

            binding.button1.setOnClickListener {
                if(counterLevel==1||counterLevel==5) {
                    isTrueAnswer(binding.button1)
                }else{
                    isFalseAnswer(binding.button1)
                }

                }
            binding.button2.setOnClickListener {
                  if(counterLevel==2){
                      isTrueAnswer(binding.button2)
                  }else{
                      isFalseAnswer(binding.button2)
                  }
                }
            binding.button3.setOnClickListener {
                if(counterLevel==3){
                    isTrueAnswer(binding.button3)
                }else{
                    isFalseAnswer(binding.button3)
                }
            }
            binding.button4.setOnClickListener {
                if(counterLevel==4){
                    isTrueAnswer(binding.button4)
                }else{
                    isFalseAnswer(binding.button4)
                }
            }



        }
    }

    @SuppressLint("ResourceAsColor")
    private fun isTrueAnswer(button:Button) {
            button.setBackgroundColor(R.color.green)
            score=+5
            binding.textViewScore.setText(score)

    }
    @SuppressLint("ResourceAsColor")
    private fun isFalseAnswer(button: Button){
        button.setBackgroundColor(R.color.red)
    //    score=-2
        binding.textViewScore.setText(score)
    }

    private fun setNumberButton() {
        var trueAnswer=numberA%numberB
        var falseAnswer1=trueAnswer+1
        var falseAnswer2=trueAnswer-1
        var falseAnswer3=trueAnswer+2
        if(counterLevel==1) {
            binding.button1.setText(trueAnswer)
            binding.button2.setText(falseAnswer1)
            binding.button3.setText(falseAnswer2)
            binding.button4.setText(falseAnswer3)
        }



    }

    private fun setRandomNumber() {
         numberA=Random().nextInt(100)
        numberB=Random().nextInt(10)
        binding.textViewA.setText(numberA)
        binding.textViewB.setText(numberB)




    }
}