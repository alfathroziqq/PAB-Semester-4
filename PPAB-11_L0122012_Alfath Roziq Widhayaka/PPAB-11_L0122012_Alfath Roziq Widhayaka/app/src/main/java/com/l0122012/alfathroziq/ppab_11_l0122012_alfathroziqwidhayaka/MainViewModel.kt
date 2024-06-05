package com.l0122012.alfathroziq.ppab_11_l0122012_alfathroziqwidhayaka

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // CALCULATOR
    fun add(a: Double, b: Double): Double {
        return a + b
    }

    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) {
            throw IllegalArgumentException("Tidak bisa dibagi dengan nol")
        }
        return a / b
    }

    // TIMER
    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long> get() = _elapsedTime

    private var isRunning = false
    private var startTime = 0L
    private val handler = Handler(Looper.getMainLooper())
    private val updateInterval = 1000L

    private val runnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                val currentTime = System.currentTimeMillis()
                _elapsedTime.value = (currentTime - startTime) / 1000
                handler.postDelayed(this, updateInterval)
            }
        }
    }

    fun startTimer() {
        if (!isRunning) {
            isRunning = true
            startTime = System.currentTimeMillis()
            handler.post(runnable)
        }
    }

    fun stopTimer() {
        isRunning = false
        handler.removeCallbacks(runnable)
    }

    fun resetTimer() {
        stopTimer()
        _elapsedTime.value = 0
    }
}