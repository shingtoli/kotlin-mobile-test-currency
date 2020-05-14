package com.shingto.kotlinmobiletestcurrency

import org.junit.Test

import org.junit.Assert.*

import com.shingto.kotlinmobiletestcurrency.model.Currency
import com.shingto.kotlinmobiletestcurrency.model.Balance

class BalanceTest {
    @Test
    fun create_balance() {
        val eur: Currency =
            Currency("EUR", "€")
        val eurBalance: Balance = Balance(eur)

        assertEquals("€0.00", eurBalance.toString())
    }

    @Test
    fun deposit_balance() {
        val usd: Currency =
            Currency("USD", "US$")
        val usdBalance: Balance = Balance(usd)

        usdBalance.deposit(2000_00)
        assertEquals("US$2,000.00", usdBalance.toString())
    }

    @Test
    fun withdraw_balance() {
        val usd: Currency =
            Currency("USD", "US$")
        val usdBalance: Balance = Balance(usd)

        usdBalance.deposit(2500_00)
        usdBalance.withdraw(1000_00)

        assertEquals(1500_00, usdBalance.value)
    }

    @Test
    fun withdraw_balance_false() {
        val usd: Currency =
            Currency("USD", "US$")
        val usdBalance: Balance = Balance(usd)

        usdBalance.deposit(999_00)
        val status = usdBalance.withdraw(1000_00)

        assertEquals(false, status)
        assertEquals(999_00, usdBalance.value)
    }
}
