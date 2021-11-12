package com.emamagic.memoryleak.nested_class_leak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import com.emamagic.memoryleak.R
import java.lang.ref.WeakReference

private const val TAG = "NestedClassActivity"
class NestedClassActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_class)
        textView = findViewById(R.id.txt_nested_class_leak)

        DownloadTask(textView).start()

    }

    class DownloadTask(textView: TextView) : Thread() {
        private val textView = WeakReference(textView)
        override fun run() {
            Handler(Looper.getMainLooper()).postDelayed({
                textView.get()?.text = "Tadaaaa"
            }, 30000)
        }
    }

}