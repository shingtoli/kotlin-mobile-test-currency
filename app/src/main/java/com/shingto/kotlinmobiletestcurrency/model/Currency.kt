package com.shingto.kotlinmobiletestcurrency.model

const val apiBaseUrl: String = "https://api.exchangeratesapi.io/latest?base="
val acceptedCurrencies = listOf<String>("SGD", "MYR", "USD", "EUR")

class Currency(val code: String, val sign: String) {
    val rates: MutableMap<String, Double> = mutableMapOf()
    val currencies: List<String> = acceptedCurrencies.filter { it != code }

    init {
        currencies.forEach {
            rates[it] = 1.0
        }
    }

    fun fetchRates(): String {
        val fetchUrl: String = apiBaseUrl + code
        return fetchUrl
        // Fuel.get(fetchUrl)
    }
}