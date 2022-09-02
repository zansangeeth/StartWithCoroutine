package com.zasa.startwithcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            delay(5000)
            Log.i(TAG, "Thread : ${Thread.currentThread().name}")
        }
        Log.i(TAG, "Thread : ${Thread.currentThread().name}")

    }
}