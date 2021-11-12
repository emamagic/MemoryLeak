package com.emamagic.memoryleak.singleton_leak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emamagic.memoryleak.R

private const val TAG = "SingletonLeakActivity"
class SingletonLeakActivity : AppCompatActivity() {

    lateinit var singletonManager: SingletonManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         *
         * Singleton leak
         * we have several way to solve that ->
         * 1. use application context instead of activity context
         * 2. assign null to activity context
         * 3. use weakReferences
         * 4. ...
        * */

        singletonManager = SingletonManager.getInstance(this)
//    way: 1.    singletonManager = SingletonManager.getInstance(applicationContext)





    }


    override fun onDestroy() {
//    way: 2.    singletonManager.destroy()
        super.onDestroy()
    }
}