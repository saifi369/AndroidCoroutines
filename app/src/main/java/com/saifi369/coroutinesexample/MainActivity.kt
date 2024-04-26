package com.saifi369.coroutinesexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.saifi369.coroutinesexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRunCode.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {
                binding.progressBar.isVisible = true

                val originalImage = BitmapFactory.decodeResource(resources, R.drawable.test_image)
                binding.ivOutput.setImageBitmap(originalImage)

                val filteredImage = applyGrayscaleFilter(originalImage)
                binding.ivOutput.setImageBitmap(filteredImage)

                binding.progressBar.isVisible = false
            }
        }
    }

    private suspend fun applyGrayscaleFilter(originalBitmap: Bitmap) =
        withContext(Dispatchers.Default) {
            val width = originalBitmap.width
            val height = originalBitmap.height

            val grayscaleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    val pixel = originalBitmap.getPixel(x, y)
                    val red = (pixel shr 16) and 0xFF
                    val green = (pixel shr 8) and 0xFF
                    val blue = pixel and 0xFF
                    val gray = (red + green + blue) / 3
                    val grayPixel = (0xFF shl 24) or (gray shl 16) or (gray shl 8) or gray
                    grayscaleBitmap.setPixel(x, y, grayPixel)
                }
            }
            grayscaleBitmap
        }
}