package com.shingto.kotlinmobiletestcurrency.model

class Balance (private val currency: Currency){
    private var value: Long = 0

    override fun toString(): String {
        return currency.displayValue(value)
    }
}