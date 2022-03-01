package com.example.collaborationproject

import android.R.color
import android.annotation.SuppressLint
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.collaborationproject.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var numberA = 0
    var numberB = 0
    var counterLevel = 1
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()


    }

    private fun initViews() {
        setRandomNumber()
        setNumberButton()
        binding.buttonCube.setOnClickListener {
            setRandomNumber()
            setNumberButton()
        }
        binding.button1.setOnClickListener {
            if (counterLevel == 1 || counterLevel == 5) {
                isTrueAnswer(binding.button1)
                binding.button2.isEnabled=false
                binding.button3.isEnabled=false
                binding.button4.isEnabled=false

            } else {
                isFalseAnswer(binding.button1)
            }

        }
        binding.button2.setOnClickListener {
            if (counterLevel == 2) {
                isTrueAnswer(binding.button2)
                binding.button1.isEnabled=false
                binding.button3.isEnabled=false
                binding.button4.isEnabled=false
            } else {
                isFalseAnswer(binding.button2)
            }
        }
        binding.button3.setOnClickListener {
            if (counterLevel == 3) {
                isTrueAnswer(binding.button3)
                binding.button2.isEnabled=false
                binding.button1.isEnabled=false
                binding.button4.isEnabled=false
            } else {
                isFalseAnswer(binding.button3)
            }
        }
        binding.button4.setOnClickListener {
            if (counterLevel == 4) {
                isTrueAnswer(binding.button4)
                binding.button2.isEnabled=false
                binding.button3.isEnabled=false
                binding.button1.isEnabled=false
            } else {
                isFalseAnswer(binding.button4)
            }
        }


    }


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    private fun isTrueAnswer(button: Button) {
        button.setBackgroundColor(getColor(R.color.green))
        score = +5
        binding.textViewScore.setText(score.toString())

    }

    @SuppressLint("ResourceAsColor")
    private fun isFalseAnswer(button: Button) {
        button.setBackgroundColor(getColor(R.color.red))

       // button.backgroundTintList()
        //    score=-2
        binding.textViewScore.setText(score.toString())
    }

    private fun setNumberButton() {
        var trueAnswer = numberA % numberB
        var falseAnswer1 = trueAnswer + 1
        var falseAnswer2 = trueAnswer - 1
        var falseAnswer3 = trueAnswer + 2
        if (counterLevel == 1) {
            binding.button1.setText(trueAnswer.toString())
            binding.button2.setText(falseAnswer1.toString())
            binding.button3.setText(falseAnswer2.toString())
            binding.button4.setText(falseAnswer3.toString())

        } else if (counterLevel == 2) {
            binding.button1.setText(trueAnswer.toString())
            binding.button2.setText(falseAnswer1.toString())
            binding.button3.setText(falseAnswer2.toString())
            binding.button4.setText(falseAnswer3.toString())
        }else if (counterLevel == 3) {
            binding.button1.setText(trueAnswer.toString())
            binding.button2.setText(falseAnswer1.toString())
            binding.button3.setText(falseAnswer2.toString())
            binding.button4.setText(falseAnswer3.toString())
        }else if (counterLevel == 4) {
            binding.button1.setText(trueAnswer.toString())
            binding.button2.setText(falseAnswer1.toString())
            binding.button3.setText(falseAnswer2.toString())
            binding.button4.setText(falseAnswer3.toString())
        }else if (counterLevel == 5) {
            binding.button1.setText(trueAnswer.toString())
            binding.button2.setText(falseAnswer1.toString())
            binding.button3.setText(falseAnswer2.toString())
            binding.button4.setText(falseAnswer3.toString())
        }


    }

    private fun setRandomNumber() {
        numberA = (0..100).random()
        numberB = (0..10).random()
        binding.textViewA.setText(numberA.toString())
        binding.textViewB.setText(numberB.toString())


    }
}
