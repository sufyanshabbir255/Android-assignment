package com.example.android_assignment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: DownloaderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imagesAdapter = ImagesAdapter(arrayListOf(), this)
        recyclerview.adapter = imagesAdapter
        viewModel.images.observe(this, { list ->
            imagesAdapter.setList(list)
        })
    }
}
