package com.emamagic.memoryleak.inner_class_leak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import com.emamagic.memoryleak.R
import java.lang.ref.WeakReference

private const val TAG = "InnerClassLeakActivity"
class InnerClassLeakActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var downloadTask: DownloadTask
    private lateinit var downloadHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ineer_class_leak)
        textView = findViewById(R.id.txt_inner_class_leak)

        /**
         *
         * if you use inner class it does not matter that you are using weakReference or not because
         * by default inner classes hold reference of the outer class also you should destroy inner class at
         * on Destroy
         *
         * */

        downloadTask = DownloadTask()
        downloadTask.start()

//        downloadHandler = Handler(Looper.getMainLooper())
//        downloadHandler.postDelayed(DownloadRunnable(), 30000)

        /**
         *
         * it is not to lead any memory leak
         * because inner class instance lives shorter than the container instance
         *
         * */
//        Test().test()

    }

    inner class DownloadTask : Thread() {
        override fun run() {
            /** if textView be there or not, this Runnable lead to memory leak */
//            sleep(30000)
            Handler(Looper.getMainLooper()).postDelayed({
                /** if textView be there this Thread lead to memory leak and if textView be comment we have no memory leak */
//                textView.text = "Tadaaaa"
            }, 30000)
        }
    }


    inner class DownloadRunnable: Runnable {
        override fun run() {
            /** if textView be there or not, this Runnable lead to memory leak */
//            textView.text = "Tadaaaa"
        }
    }

    inner class Test {
        fun test() {
            textView.text = "Tadaaaa"
        }
    }


    override fun onDestroy() {
//        downloadTask.destroy()
//        downloadHandler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }


}