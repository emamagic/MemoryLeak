package com.emamagic.memoryleak.nested_class_leak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emamagic.memoryleak.R

class NestedClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_class)
    }
}