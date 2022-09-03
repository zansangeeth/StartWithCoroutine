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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClickMe.setOnClickListener {

            CoroutineScope(IO).launch {
                fakeApiCall()
                withContext(Main){
                    tvText.text = fakeApiCall()
                }
            }


        }
    }

    private suspend fun fakeApiCall() : String{
        val results1 = getResults1FromApi()
        return results1
    }

    private suspend fun getResults1FromApi() : String{
        logThread("getResults1FromApi")
        delay(2000)
        return RESULT_1
    }

    private fun logThread(methodName : String){
        println("debug : $methodName - ${Thread.currentThread().name}")
    }


}