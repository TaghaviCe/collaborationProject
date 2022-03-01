package com.example.collaborationproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.collaborationproject.databinding.ActivityMainBinding
import com.example.collaborationproject.databinding.ActivityResultBinding

class resultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    lateinit var prefs : SharedPreferences
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = getSharedPreferences(resources.getString(R.string.app_name), MODE_PRIVATE)
        val editor =  prefs.edit()
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(savedInstanceState!= null){
            var myText=savedInstanceState.getString("textView")
            var myText1 = savedInstanceState.getString("textViewScore")
            var myText2=savedInstanceState.getString("textViewRecord")
            var myText3=savedInstanceState.getString("textButtonExit")
            var myText4=savedInstanceState.getString("textButtonReset")
            binding.textView.text=myText
            binding.textViewScore.text=myText1
            binding.textViewRecord.text=myText2
            binding.buttonExit.text=myText3
            binding.buttonReset.text=myText4
        }
        score = intent.getIntExtra("score",0)
        binding.textViewScore.setText(score.toString())
        binding.textViewRecord.setText("")
        checkRecord()
        binding.buttonReset.setOnClickListener {
            if(score > prefs.getInt("score",0)) {
                editor.putInt("score", score)
                editor.apply()
            }
            back()

        }
        binding.buttonExit.setOnClickListener {
            if(score > prefs.getInt("score",0)) {
                editor.putString("score", binding.textViewScore.text.toString())
                editor.apply()
            }
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);

        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("textView" , binding.textView.text.toString())
        outState.putString("textViewScore",binding.textViewScore.toString())
        outState.putString("textViewRecord",binding.textViewRecord.toString())
        outState.putString("textButtonExit",binding.buttonExit.text.toString())
        outState.putString("textButtonReset",binding.buttonReset.text.toString())


        super.onSaveInstanceState(outState)
    }

    private fun back() {
        val result= Intent()
        setResult(RESULT_OK,result)
        finish()
    }

    fun checkRecord(){
        if(score > prefs.getInt("score",0)){
            binding.textViewRecord.text = "NEW RECORD"
        }
    }

}