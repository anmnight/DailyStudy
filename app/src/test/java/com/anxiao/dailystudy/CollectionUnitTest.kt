package com.anxiao.dailystudy

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CollectionUnitTest {

    @Test
    fun test_range() {
        val range = 1..100
        for (i in range step 2) {
            println("current : $i")
        }

    }

    @Test
    fun test_list() {
        val list = listOf(1, 2, 3, 4, 5)
        val result = list.map {
            println("list : $it")
            it * 2
        }.filter {
            println("filter : $it")
            it % 3 == 0
        }
        println("first : ${result.first()}")
    }

    @Test
    fun test_sequence() {
        val sequence = sequenceOf(1, 2, 3, 4, 5)
        val result = sequence.map {
            println("list : $it")
            it * 2
        }.filter {
            println("filter : $it")
            it % 3 == 0
        }
        println("first : ${result.first()}")

    }
}