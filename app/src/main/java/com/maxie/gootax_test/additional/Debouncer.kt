package com.maxie.gootax_test.additional

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Debouncer(private val coroutineScope: CoroutineScope) {
    private var debounceJob: Job? = null

    fun debounce(waitMs: Long, action: () -> Unit) {
        debounceJob?.cancel()
        debounceJob = coroutineScope.launch {
            delay(waitMs)
            action()
        }
    }
}