package com.glureau.minikard.ext

import java.math.BigDecimal
import java.text.NumberFormat

// Over-simplification here, we don't handle the currency change and display
// values with the default system currency.
fun BigDecimal.formatCurrency() = NumberFormat.getCurrencyInstance().format(toDouble())