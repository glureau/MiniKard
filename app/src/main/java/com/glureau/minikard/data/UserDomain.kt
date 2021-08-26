package com.glureau.minikard.data

data class UserDomain(
    val firstName: String,
    val balance: MoneyDomain,
    val transactions: List<TransactionDomain>
)
