package com.josuna85.superheroregister

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import com.josuna85.superheroregister.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var heroImageCam: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val superHeroName:String = binding.edtxtHeroName.text.toString()
            val alterEgo:String = binding.edtxtAlterEgo.text.toString()
            val bio:String = binding.edtxtBioDescription.text.toString()
            val power: Float = binding.powerbarRating.rating

            val hero = SuperHero(superHeroName, alterEgo, bio, power)
            openDetailActivity(hero)
        }
        heroImageCam = binding.heroImage

        heroImageCam.setOnClickListener {
            openCamera()
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureLauncher.launch(cameraIntent)
    }
    private val takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
        if(result.resultCode == Activity.RESULT_OK){
            val data: Intent? = result.data
            val heroBitmap = data?.extras?.get("data") as Bitmap
            heroImageCam.setImageBitmap(heroBitmap)
        }
    }

    private fun openDetailActivity(superHero: SuperHero){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY,superHero)
        intent.putExtra(DetailActivity.BITMAP_KEY,heroImageCam.drawable.toBitmap())
        startActivity(intent)
    }


}