package com.glureau.minikard.ui.home

import com.glureau.minikard.ui.shared.TransactionViewState

data class HomeViewState(
    val firstName: String = "-",
    val balance: String = "-",
    val transactions: List<TransactionViewState> =
        List(3) { // Fake data for placeholder during loading
            TransactionViewState()
        },
    val selectedTransaction: TransactionViewState? = null
)

sealed class HomeViewEffect {
    data class OpenTransactionDetails(val transactionViewState: TransactionViewState) :
        HomeViewEffect()
}