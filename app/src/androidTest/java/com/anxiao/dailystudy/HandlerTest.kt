package com.anxiao.dailystudy

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HandlerTest {

    @Test
    fun handler_test() {
        val thread = HandlerThread("worker")
        thread.start()

        val handler = object : Handler(thread.looper) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                println("handler message..")
            }


        }

        handler.post {
            println("test..")
        }

        handler.sendEmptyMessage(0)


    }


    @Test
    fun test() {
        System.gc()
    }
}