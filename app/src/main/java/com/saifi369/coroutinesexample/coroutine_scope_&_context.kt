package com.saifi369.coroutinesexample

import kotlinx.coroutines.*

private val scope = CoroutineScope(Dispatchers.Default + CoroutineName("S100"))

fun main() {

    scope.launch(Dispatchers.IO) {

    }

    Thread.sleep(1000)
    onDestroy()
}

private fun onDestroy() {
    println("cancelling scope")
    scope.cancel()
}