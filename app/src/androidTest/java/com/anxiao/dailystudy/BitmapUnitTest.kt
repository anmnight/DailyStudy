package com.anxiao.dailystudy

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BitmapUnitTest {

    @Test
    fun decode_res_test() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        val optional = BitmapFactory.Options()
        optional.inPreferredConfig = Bitmap.Config.ARGB_8888

        val hBitmap =
            BitmapFactory.decodeResource(context.resources, R.mipmap.food_hdpi)

        val xBitmap =
            BitmapFactory.decodeResource(context.resources, R.mipmap.food_xhdpi)

        //不同dpi下，同张图片解析出 Bitmap 大小不同
        println("hdpi bitmap size : ${hBitmap.byteCount}")
        println("xhdpi bitmap size : ${xBitmap.byteCount}")

    }
}