package com.glureau.minikard.ui.home

import com.glureau.minikard.ui.shared.TransactionViewState

data class HomeViewState(
    val firstName: String = "-",
    val transactions: List<TransactionViewState> = List(3) { TransactionViewState("-", "-", "-") },
)
