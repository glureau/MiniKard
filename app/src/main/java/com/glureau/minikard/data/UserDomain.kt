package com.glureau.minikard.data

data class UserDomain(
    val firstName: String,
    val transactions: List<TransactionDomain>
)
