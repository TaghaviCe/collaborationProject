package com.example.collaborationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.collaborationproject.databinding.ActivityMainBinding
import com.example.collaborationproject.databinding.ActivityResultBinding

class resultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    var exit=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setContentView(R.layout.activity_main)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var intent=intent.getIntExtra("score",0)
        binding.textViewScore.setText(intent.toString())
        binding.buttonReset.setOnClickListener {
            back()
        }
        binding.buttonExit.setOnClickListener {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);

        }


    }

    private fun back() {
        val result= Intent()
        setResult(RESULT_OK,result)
        finish()
    }


}