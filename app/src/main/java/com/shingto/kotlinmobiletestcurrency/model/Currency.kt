package com.shingto.kotlinmobiletestcurrency.model

import java.text.DecimalFormat

const val apiBaseUrl: String = "https://api.exchangeratesapi.io/latest?base="
val acceptedCurrencies = listOf<String>("SGD", "MYR", "USD", "EUR")

val centsFormat: DecimalFormat = DecimalFormat("#,###.##")
val baseFormat: DecimalFormat = DecimalFormat("#,###")

class Currency(val code: String, val sign: String, val usesCents: Boolean = true) {
    val rates: MutableMap<String, Double> = mutableMapOf()
    val currencies: List<String> = acceptedCurrencies.filter { it != code }

    init {
        currencies.forEach {
            rates[it] = 1.0
        }
    }

    fun displayValue(value: Long): String {
        var numstr: String = if (usesCents) centsFormat.format(value / 100.0) else baseFormat.format(value)
        return "${sign}${numstr}"
    }

    fun fetchRates(): String {
        val fetchUrl: String = apiBaseUrl + code
        return fetchUrl
        // Fuel.get(fetchUrl)
    }
}