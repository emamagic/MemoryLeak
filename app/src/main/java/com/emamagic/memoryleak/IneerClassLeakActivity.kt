package com.emamagic.memoryleak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class IneerClassLeakActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ineer_class_leak)
    }
}