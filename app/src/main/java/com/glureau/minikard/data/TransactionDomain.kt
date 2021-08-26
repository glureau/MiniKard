package com.glureau.minikard.data

import java.util.*

data class TransactionDomain(
    val id: String,
    val title: String?,
    val category: String?,
    val amount: MoneyDomain,
    val processedAt: Date,
    val emitterName: String,
    val emitterAvatarUrl: String?,
    val comments: List<CommentDomain>
)
