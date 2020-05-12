package com.shingto.kotlinmobiletestcurrency

import org.junit.Test

import org.junit.Assert.*

import com.shingto.kotlinmobiletestcurrency.model.Currency

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CurrencyTest {
    @Test
    fun create_currency() {
        val eur: Currency =
            Currency("EUR", "€")
        assertEquals(eur.code, "EUR")
        assertEquals(eur.sign, "€")

    }
}
