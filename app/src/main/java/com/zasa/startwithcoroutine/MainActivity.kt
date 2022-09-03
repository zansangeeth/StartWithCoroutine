package com.zasa.startwithcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val RESULT_1 = "results 01"
    private val RESULT_2 = "results 02"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClickMe.setOnClickListener {

            CoroutineScope(IO).launch {
                fakeApiCall1()
                fakeApiCall2()
                withContext(Main) {
                    tvText.text = fakeApiCall1()
                    tvText.text = fakeApiCall2()
                }
            }
        }
    }

    private suspend fun fakeApiCall1(): String {
        val results1 = getResults1FromApi()
        return results1
    }

    private suspend fun fakeApiCall2(): String {
        val results2 = getResults2FromApi()
        return results2
    }

    private suspend fun getResults1FromApi(): String {
        logThread("getResults1FromApi")
        delay(2000)
        return RESULT_1
    }

    private suspend fun getResults2FromApi(): String {
        logThread("getResults2FromApi")
        delay(2000)
        return RESULT_2
    }

    private fun logThread(methodName: String) {
        println("debug : $methodName - ${Thread.currentThread().name}")
    }


}