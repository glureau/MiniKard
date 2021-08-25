package com.glureau.minikard.data

data class TransactionDomain(
    val id: String,
    val title: String?,
    val category: String?,
    val amount: MoneyDomain,
)
