package com.shingto.kotlinmobiletestcurrency.model

class Balance (private val currency: Currency){
    var value: Long = 0
        private set

    fun deposit(cents: Long): Long {
        value += cents
        return value
    }

    fun withdraw(cents: Long): Boolean {
        if (value < cents) {
            return false
        }

        value -= cents
        return true
    }

    override fun toString(): String {
        return currency.displayValue(value)
    }
}