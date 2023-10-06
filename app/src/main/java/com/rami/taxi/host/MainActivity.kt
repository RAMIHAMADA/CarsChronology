package com.rami.taxi.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rami.taxi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
