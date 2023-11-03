package com.auwfar.indonesiaku

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auwfar.indonesiaku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpen.setOnClickListener {
            val mapUri = Uri.parse("geo:4.0308974,91.6239389?q=" + Uri.encode("Aceh"))
            val intent = Intent(Intent.ACTION_VIEW, mapUri).apply {
                setPackage("com.google.android.apps.maps")
            }
            startActivity(intent)
        }
    }
}