package com.glureau.minikard.data

import java.math.BigDecimal

data class MoneyDomain(
    val amount: BigDecimal,
    val currencyIsoCode: String,
)
