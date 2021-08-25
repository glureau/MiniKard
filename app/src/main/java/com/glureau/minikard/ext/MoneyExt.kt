package com.glureau.minikard.ext

import com.glureau.minikard.data.MoneyDomain
import java.text.NumberFormat
import java.util.*

const val UNBREAKABLE_SPACE = "\u00a0"

// Over-simplification here, we don't handle the currency change and display
// values with the default system currency.
fun MoneyDomain.formatCurrency(): String {
    val curr = NumberFormat.getCurrencyInstance()
    curr.currency = Currency.getInstance(currencyIsoCode)
    return curr.format(amount).replace(" ", UNBREAKABLE_SPACE)
}