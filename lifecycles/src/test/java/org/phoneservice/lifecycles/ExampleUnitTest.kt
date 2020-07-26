package org.phoneservice.lifecycles

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun doTest1() {
        val person1 = Person("张三",16)
        val person2 = Person("李四",16)
        println("==========person1.name:${person1.name}====person2.name:${person2.name}")
    }
}
