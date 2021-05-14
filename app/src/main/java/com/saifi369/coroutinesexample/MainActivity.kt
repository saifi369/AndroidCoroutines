package com.saifi369.coroutinesexample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saifi369.coroutinesexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.math.BigInteger
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set app theme
        setTheme(R.style.Theme_CoroutinesExample)
        setContentView(binding.root)

        binding.btnRunCode.setOnClickListener {

            CoroutineScope(Dispatchers.Main.immediate).launch {
                delay(3000)
                showMessage()
            }
        }
    }

    private fun showMessage(){
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
    }

    suspend fun findBigPrime(): BigInteger =
        BigInteger.probablePrime(4096, java.util.Random())

}