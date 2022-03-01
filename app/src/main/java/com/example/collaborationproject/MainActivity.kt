package com.example.collaborationproject

import android.R.color
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
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

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(savedInstanceState!= null){
            var myText = savedInstanceState.getString("textViewScore")
            var myText1 = savedInstanceState.getString("textViewA")
            var myText2 = savedInstanceState.getString("textViewB")
            var myText3 = savedInstanceState.getInt("level")
            var myText4=savedInstanceState.getString("textButton1")
            var myText5=savedInstanceState.getString("textButton2")
            var myText6=savedInstanceState.getString("textButton3")
            var myText7=savedInstanceState.getString("textButton4")
            var myText8=savedInstanceState.getString("textButtonCube")


            binding.textViewScore.text = myText
            binding.textViewA.text=myText1
            binding.textViewB.text=myText2
            counterLevel=myText3
            binding.button1.setText(myText4.toString())
            binding.button2.setText(myText5.toString())
            binding.button3.setText(myText6.toString())
            binding.button4.setText(myText7.toString())
            binding.buttonCube.setText(myText8.toString())

        }
        initViews()

    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("textViewScore" , binding.textViewScore.text.toString())
        outState.putString("textViewA" , binding.textViewA.text.toString())
        outState.putString("textViewB" , binding.textViewB.text.toString())
        outState.putInt("level" , counterLevel)
        outState.putString("textButton1",binding.button1.text.toString())
        outState.putString("textButton2",binding.button2.text.toString())
        outState.putString("textButton3",binding.button3.text.toString())
        outState.putString("textButton4",binding.button4.text.toString())
        outState.putString("textButtonCube",binding.buttonCube.text.toString())
        super.onSaveInstanceState(outState)
    }

    private fun initViews() {
        setRandomNumber()
        setNumberButton()
        binding.buttonCube.setOnClickListener {
            if (counterLevel <= 4) {
                setRandomNumber()
                counterLevel++
                setNumberButton()
                resetColor()
                binding.button1.isEnabled = true
                binding.button3.isEnabled = true
                binding.button4.isEnabled = true
                binding.button2.isEnabled = true
            } else {
                var intent = Intent(this, resultActivity::class.java)
                intent.putExtra("score", score)
                startForResult.launch(intent)
            }
        }
        binding.button1.setOnClickListener {
            if (counterLevel == 1 || counterLevel == 5) {
                isTrueAnswer(binding.button1)
                binding.button2.isEnabled = false
                binding.button3.isEnabled = false
                binding.button4.isEnabled = false

            } else {
                isFalseAnswer(binding.button1)
                binding.button2.isEnabled = false
                binding.button3.isEnabled = false
                binding.button4.isEnabled = false
            }

        }
        binding.button2.setOnClickListener {
            if (counterLevel == 2) {
                isTrueAnswer(binding.button2)
                binding.button1.isEnabled = false
                binding.button3.isEnabled = false
                binding.button4.isEnabled = false
            } else {
                isFalseAnswer(binding.button2)
                binding.button3.isEnabled = false
                binding.button1.isEnabled = false
                binding.button4.isEnabled = false
            }
        }
        binding.button3.setOnClickListener {
            if (counterLevel == 3) {
                isTrueAnswer(binding.button3)
                binding.button2.isEnabled = false
                binding.button1.isEnabled = false
                binding.button4.isEnabled = false
            } else {
                isFalseAnswer(binding.button3)
                binding.button2.isEnabled = false
                binding.button1.isEnabled = false
                binding.button4.isEnabled = false
            }
        }
        binding.button4.setOnClickListener {
            if (counterLevel == 4) {
                isTrueAnswer(binding.button4)
                binding.button2.isEnabled = false
                binding.button3.isEnabled = false
                binding.button1.isEnabled = false
            } else {
                isFalseAnswer(binding.button4)
                binding.button2.isEnabled = false
                binding.button1.isEnabled = false
                binding.button3.isEnabled = false
            }
        }


    }

    private fun resetColor() {
        binding.button1.setBackgroundColor(getColor(R.color.purple_500))
        binding.button2.setBackgroundColor(getColor(R.color.purple_500))
        binding.button3.setBackgroundColor(getColor(R.color.purple_500))
        binding.button4.setBackgroundColor(getColor(R.color.purple_500))
    }


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    private fun isTrueAnswer(button: Button) {
        button.setBackgroundColor(getColor(R.color.green))
        score = score + 5
        binding.textViewScore.setText(score.toString())

    }

    @SuppressLint("ResourceAsColor")
    private fun isFalseAnswer(button: Button) {
        button.setBackgroundColor(getColor(R.color.red))
        score = score - 2
        binding.textViewScore.setText(score.toString())
    }

    private fun setNumberButton() {
        var trueAnswer = numberA % numberB
        var falseAnswer1 = trueAnswer + 1
        var falseAnswer2 = trueAnswer + 3
        var falseAnswer3 = trueAnswer + 2
        if (counterLevel == 1) {
            binding.button1.setText(trueAnswer.toString())
            binding.button2.setText(falseAnswer1.toString())
            binding.button3.setText(falseAnswer2.toString())
            binding.button4.setText(falseAnswer3.toString())

        } else if (counterLevel == 2) {
            binding.button1.setText(falseAnswer1.toString())
            binding.button2.setText(trueAnswer.toString())
            binding.button3.setText(falseAnswer2.toString())
            binding.button4.setText(falseAnswer3.toString())
        } else if (counterLevel == 3) {
            binding.button1.setText(falseAnswer2.toString())
            binding.button2.setText(falseAnswer1.toString())
            binding.button3.setText(trueAnswer.toString())
            binding.button4.setText(falseAnswer3.toString())
        } else if (counterLevel == 4) {
            binding.button1.setText(falseAnswer3.toString())
            binding.button2.setText(falseAnswer1.toString())
            binding.button3.setText(falseAnswer2.toString())
            binding.button4.setText(trueAnswer.toString())
        } else if (counterLevel == 5) {
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

    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                counterLevel = 1
                setRandomNumber()
                setNumberButton()
                resetColor()
                binding.button1.isEnabled = true
                binding.button3.isEnabled = true
                binding.button4.isEnabled = true
                binding.button2.isEnabled = true
                score=0
                binding.textViewScore.setText(score.toString())


            }
        }
}
