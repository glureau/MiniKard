package com.glureau.minikard.data

import com.glureau.minikard.data.apollo.UserTransactionsQuery
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*


fun UserTransactionsQuery.Me.toDomain() = UserDomain(
    firstName = this.profile?.firstName ?: "-",
    balance = MoneyDomain(
        // Let's consider a user always have a bank account...
        amount = BigDecimal(String.format(Locale.ROOT, "%.2f", this.bankAccount!!.balance.value)),
        currencyIsoCode = this.bankAccount.balance.currency!!.isoCode, // Let's consider a Money always have a currency...
    ),
    transactions = this.typedTransactions?.edges?.mapNotNull { it?.node?.toDomain() } ?: emptyList()
)

fun UserTransactionsQuery.Node.toDomain() = TransactionDomain(
    id = id,
    title = title,
    category = category?.name,
    emitterName = user.firstName + " " + user.lastName,
    emitterAvatarUrl = user.avatar?.url,
    amount = this.amount!!.toDomain(),// Let's consider a Transaction always have an amount...
    processedAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(processedAt as String),
    comments = this.comments?.edges?.mapNotNull { it?.node?.toDomain() } ?: emptyList()
)

fun UserTransactionsQuery.Node1.toDomain() = CommentDomain(
    id = id,
    authorFirstName = user.firstName ?: "-",
    authorLastName = user.lastName ?: "-",
    authorAvatarUrl = user.avatar?.url,
    // Java7 solution not super clean, should rework with TemporalAccessor https://stackoverflow.com/a/60214805/1898596
    createdAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(createdAt as String),
    content = comment,
)

fun UserTransactionsQuery.Amount.toDomain() = MoneyDomain(
    amount = BigDecimal(String.format(Locale.ROOT, "%.2f", value)),
    currencyIsoCode = currency!!.isoCode, // Let's consider a Money always have a currency...
)