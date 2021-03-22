package com.dengiz.searchmovie.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dengiz.searchmovie.R
import com.dengiz.searchmovie.vm.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SearchMovie)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}