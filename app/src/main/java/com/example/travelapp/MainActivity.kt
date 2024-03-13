package com.example.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.travelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var currentImage = 0
    private lateinit var image: ImageView
    var places = arrayOf("Taj Mahal","Lotus Temple", "India Gate", "Qutab Minar", "Char Minar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibtnNxt.setOnClickListener {

            val currentImageString = "ivPic$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5 + currentImage + 1) % 5
            val idImageToShowString = "ivPic$currentImage"
            val idImageToShowStringInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowStringInt)
            image.alpha = 1f

            binding.tvName.text = places[currentImage]
        }

        binding.ibtnPrev.setOnClickListener {
            var currentImageString = "ivPic$currentImage"
            var idCurrentImageInt = this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5 + currentImage - 1) % 5
            var idImageToShowString = "ivPic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            binding.tvName.text = places[currentImage]
        }
    }
}