package com.anxiao.dailystudy

import kotlinx.coroutines.flow.emptyFlow
import org.junit.Test
import java.lang.Exception
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class Dog : Animal {
    override fun eat() {
        println("dog eat food")
    }

}

interface Animal {
    fun eat()

}

class AnimalProxy(private val animal: Animal) : Animal {
    override fun eat() {
        println("饭钱洗手")
        animal.eat()
        println("饭后擦嘴")
    }
}


class EatProxy(private val bean: Any) : InvocationHandler {

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {

        method?.let {
            if (method.name == "eat") {
                println("饭钱洗手")
                method.invoke(bean, *(args ?: arrayOfNulls<Any>(0)))
                println("饭后擦嘴")
            }
        }

        return Any()
    }

}


class ProxyUnitTest {
    @Test
    fun static_proxy_test() {
        val animal = AnimalProxy(Dog())
        animal.eat()
    }

    @Test
    fun dynamic_proxy_test() {
        val proxy = EatProxy(Dog())
        val classLoader = proxy.javaClass.classLoader
        val clazz = arrayOf(Animal::class.java)
        val animal = Proxy.newProxyInstance(classLoader, clazz, proxy) as Animal

        animal.eat()
    }

}


