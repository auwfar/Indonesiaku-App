package com.auwfar.indonesiaku.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.auwfar.indonesiaku.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private val provinceAdapter by lazy { ProvinceAdapter {
        val intent = Intent(Intent.ACTION_VIEW, it?.getMapsUri()).apply {
            setPackage("com.google.android.apps.maps")
        }
        startActivity(intent)
    } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.rvProvinces) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = provinceAdapter
        }

        observeLiveData()
        viewModel.getProvinces()
    }

    private fun observeLiveData() {
        viewModel.provinces.observe(this) {
            binding.pbLoading.isVisible = false
            provinceAdapter.setItems(it.orEmpty())
        }
    }
}