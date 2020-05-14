package com.shingto.kotlinmobiletestcurrency

import org.junit.Test

import org.junit.Assert.*

import com.shingto.kotlinmobiletestcurrency.model.Currency

class CurrencyTest {
    @Test
    fun create_currency() {
        val eur: Currency =
            Currency("EUR", "€")
        assertEquals("EUR", eur.code)
        assertEquals("€", eur.sign)

    }

    @Test
    fun display_value_cents() {
        val sgd: Currency =
            Currency("SGD", "S$")
        assertEquals("S$12,345.67", sgd.displayValue(1234567))
    }

    @Test
    fun display_value_cents_zero() {
        val sgd: Currency =
            Currency("SGD", "S$")
        assertEquals("S$0.00", sgd.displayValue(0))
    }

    @Test
    fun display_value_base() {
        val jpy: Currency =
            Currency("JPY", "¥", usesCents = false)
        assertEquals("¥1,234,567", jpy.displayValue(1234567))
    }
}
