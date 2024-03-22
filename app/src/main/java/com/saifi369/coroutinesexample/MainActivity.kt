package com.saifi369.coroutinesexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saifi369.coroutinesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRunCode.setOnClickListener {

        }
    }
}