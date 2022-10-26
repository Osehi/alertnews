package com.polish.alertnews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.polish.alertnews.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
